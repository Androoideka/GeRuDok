package designmode.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import document.model.Slot;
import document.view.MainPageDrawer;
import helpers.UserSpaceScaler;

public class SelectState extends State {
	
	private Slot selectedSlot;

	public SelectState(MainPageDrawer pageView) {
		super(pageView);
	}

	public void mousePressed(MouseEvent e) {
		Point2D point = UserSpaceScaler.getInstance().toUserSpace(e.getPoint(), pageView.getSize());
		if (e.getButton()==MouseEvent.BUTTON1) {
			Slot slot = pageView.getPage().findSlotAtPosition(point);
			if(slot != null) {
				if(selectedSlot != null) {
					selectedSlot.setSelected(false);
				}
				selectedSlot = slot;
				selectedSlot.setSelected(true);
				pageView.getStateManager().setGrabState(selectedSlot, point);
			}
			if(selectedSlot != null) {
				if(selectedSlot.getHandleForPoint(point) != null) {
					pageView.getStateManager().setRescaleState(selectedSlot, point);
				}
			}
		}else if(e.getButton()==MouseEvent.BUTTON3) {
			if(selectedSlot!=null) {
				pageView.getStateManager().setRotateState(selectedSlot, point);
			}
		}
	}
	
	public Slot getSelectedSlot() {
		return selectedSlot;
	}
	
	public void deselect() {
		if(selectedSlot != null) {
			selectedSlot.setSelected(false);
		}
		selectedSlot = null;
	}
}
