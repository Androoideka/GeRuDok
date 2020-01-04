package designmode.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import designmode.view.MultimedialEditor;
import designmode.view.SlotContentChooser;
import designmode.view.TextEditor;
import document.model.Slot;
import document.view.MainPageView;
import helpers.UserSpaceScaler;

public class SelectState extends State {

	public SelectState(MainPageView pageView) {
		super(pageView);
	}

	public void mousePressed(MouseEvent e) {
		Point2D point = UserSpaceScaler.getInstance().toUserSpace(e.getPoint(), pageView.getSize());
		Slot slot = pageView.getPage().findSlotAtPosition(point);
		if(e.getButton()==MouseEvent.BUTTON1 && e.getClickCount()==2) {
			if(slot!=null && pageView.getSelectionModel().getNumberOfSlots()==1) {
				if(slot.getTextSlot()==false && slot.getMultimedialSlot()==false) {
					SlotContentChooser scc=new SlotContentChooser(slot);
					if(scc.getSelection().toString()=="Textual") {
						slot.setTextSlot(true);
						TextEditor te=new TextEditor();
						slot.setEditor(te);
					}else if(scc.getSelection().toString()=="Multimedial") {
						slot.setMultimedialSlot(true);
						MultimedialEditor me=new MultimedialEditor();
						slot.setEditor(me);
					}else {
						System.out.println("nije odabran editor");
					}
				}else if(slot.getEditor()!=null) {
					slot.getEditor().show();
				}
			}
		}
		else if(e.getButton()==MouseEvent.BUTTON1) {
			if(slot == null || !pageView.getSelectionModel().getSlots().contains(slot)) {
				if(!e.isControlDown()) {
					pageView.getSelectionModel().removeAll();
				}
				if(slot != null) {
					pageView.getSelectionModel().addSlot(slot);
				}
			}
			if(pageView.getSelectionModel().getHandleForPoint(point) != null) {
				pageView.getStateManager().setRescaleState(point);
			}
			else {
				pageView.getStateManager().setGrabState(point);
			}
		}else if(e.getButton()==MouseEvent.BUTTON3) {
			if(pageView.getSelectionModel().getNumberOfSlots() > 0) {
				pageView.getStateManager().setRotateState(point);
			}
		}
	}
	
	public void deselect() {
		pageView.getSelectionModel().removeAll();
	}
}
