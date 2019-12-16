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
	private Handle selectedHandle;

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
				selectedHandle = selectedSlot.getHandleForPoint(start);
			}
		}
	}
	
	public void mouseDragged(MouseEvent e, Page p) {
		if(start != null) {
			end = e.getPoint();
			double distanceX = end.getX() - start.getX();
			double distanceY = end.getY() - start.getY();
			if(selectedHandle != null) {
				scale(selectedHandle, distanceX, distanceY);
			}
			else {
				Point2D position = (Point2D) selectedSlot.getPosition().clone();
				position.setLocation(position.getX() + distanceX, position.getY() + distanceY);
				selectedSlot.setPosition(position);
			}
			start = end;
		}
	}
	
	public void mouseReleased(MouseEvent e, Page p) {
		start = null;
		selectedHandle = null;
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
	
	public void scale(Handle h, double distanceX, double distanceY) {
		Point2D position = selectedSlot.getPosition();
		Dimension size = selectedSlot.getSize();
		double x=position.getX(), y=position.getY(),
				sizeX = size.getWidth(), sizeY = size.getHeight();
		
		if(h == Handle.NORTHWEST || h == Handle.NORTH || h == Handle.NORTHEAST){
			y += distanceY;
			sizeY -= distanceY;
		}
		if(h == Handle.SOUTHWEST || h == Handle.SOUTH || h == Handle.SOUTHEAST){
			sizeY += distanceY;
		}
		if(h == Handle.NORTHWEST || h == Handle.WEST || h == Handle.SOUTHWEST){
			x += distanceX;
			sizeX -= distanceX;
		}
		if(h == Handle.NORTHEAST || h == Handle.EAST || h == Handle.SOUTHEAST){
			sizeX += distanceX;
		}
		
		Point2D newPosition = (Point2D)position.clone();
		newPosition.setLocation(x, y);
		Dimension newSize = new Dimension();
		newSize.setSize(sizeX, sizeY);
		
		selectedSlot.setPosition(newPosition);
		selectedSlot.setSize(newSize);
	}
}
