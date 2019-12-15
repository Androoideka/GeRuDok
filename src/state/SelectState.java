package state;

import java.awt.event.MouseEvent;

import model.document.Page;
import model.document.Slot;
import model.workspace.Document;

public class SelectState extends State {
	
	private Slot selectedSlot;

	public SelectState(Document mediator) {
		super(mediator);
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
