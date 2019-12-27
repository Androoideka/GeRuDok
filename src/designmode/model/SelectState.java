package designmode.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import document.model.Slot;
import document.view.MainPageView;
import helpers.UserSpaceScaler;

public class SelectState extends State {

	public SelectState(MainPageView pageView) {
		super(pageView);
	}

	public void mousePressed(MouseEvent e) {
		Point2D point = UserSpaceScaler.getInstance().toUserSpace(e.getPoint(), pageView.getSize());
		if (e.getButton()==MouseEvent.BUTTON1) {
			
			Slot slot = pageView.getPage().findSlotAtPosition(point);
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
