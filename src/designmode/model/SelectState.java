package designmode.model;

import java.awt.event.MouseEvent;

import document.model.Slot;
import document.view.MainPageDrawer;

public class SelectState extends State {
	
	private Slot selectedSlot;

	public SelectState(MainPageDrawer pageView) {
		super(pageView);
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton()==MouseEvent.BUTTON1) {
			Slot slot = pageView.getPage().findSlotAtPosition(e.getPoint());
			if(slot != null) {
				if(selectedSlot != null) {
					selectedSlot.setSelected(false);
				}
				selectedSlot = slot;
				selectedSlot.setSelected(true);
				pageView.getStateManager().setGrabState(selectedSlot, e.getPoint());
			}
			if(selectedSlot != null) {
				if(selectedSlot.getHandleForPoint(e.getPoint()) != null) {
					pageView.getStateManager().setRescaleState(selectedSlot, e.getPoint());
				}
			}
		}else if(e.getButton()==MouseEvent.BUTTON3) {
			if(selectedSlot!=null) {
				pageView.getStateManager().setRotateState(selectedSlot, e.getPoint());
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
