package state;

import java.awt.event.MouseEvent;

import model.document.Page;
import model.document.Slot;
import model.workspace.Document;

public class SelectState extends State {
	
	private Slot selectedSlot;

	public SelectState(Document doc) {
		super(doc);
	}

	public void mousePressed(MouseEvent e, Page p) {
		if (e.getButton()==MouseEvent.BUTTON1) {
			Slot slot = p.findSlotAtPosition(e.getPoint());
			if(slot != null) {
				if(selectedSlot != null) {
					selectedSlot.setSelected(false);
				}
				selectedSlot = slot;
				selectedSlot.setSelected(true);
				doc.getStateManager().setGrabState(selectedSlot, e.getPoint());
			}
			if(selectedSlot != null) {
				if(selectedSlot.getHandleForPoint(e.getPoint()) != null) {
					doc.getStateManager().setRescaleState(selectedSlot, e.getPoint());
				}
			}
		}else if(e.getButton()==MouseEvent.BUTTON3) {
			if(selectedSlot!=null) {
				doc.getStateManager().setRotateState(selectedSlot, e.getPoint());
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
