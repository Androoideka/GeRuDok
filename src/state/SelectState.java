package state;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import gui.painters.Handle;
import model.document.Page;
import model.document.Slot;
import model.workspace.Document;

public class SelectState extends State {
	
	private Slot selectedSlot;
	private Point2D start;
	private Point2D end;

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
				start = e.getPoint();
			}
			if(selectedSlot != null) {
				if(selectedSlot.getHandleForPoint(e.getPoint()) != null) {
					doc.getStateManager().setRescaleState(selectedSlot, e.getPoint());
				}
			}
		}/*else if(e.getButton()==MouseEvent.BUTTON3) {
			Slot slot = p.findSlotAtPosition(e.getPoint());
			if(slot != null) {
				if(selectedSlot != null) {
					selectedSlot.setRotatable(false);
				}
				selectedSlot = slot;
				selectedSlot.setRotatable(true);
				start = e.getPoint();
			}
			if(selectedSlot != null) {
				selectedHandle = selectedSlot.getHandleForPoint(e.getPoint());
				if(selectedHandle != null) {
					start = e.getPoint();
				}
			}
		}*/
	}
	
	public void mouseDragged(MouseEvent e, Page p) {
		if(start != null) {				
			end = e.getPoint();
			double distanceX = end.getX() - start.getX();
			double distanceY = end.getY() - start.getY();
			Point2D position = (Point2D) selectedSlot.getPosition().clone();
			position.setLocation(position.getX() + distanceX, position.getY() + distanceY);
			selectedSlot.setPosition(position);
			start = end;
		}
	}
	
	public void mouseReleased(MouseEvent e, Page p) {
		start = null;
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
