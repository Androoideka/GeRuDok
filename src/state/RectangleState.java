package state;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import model.document.Page;
import model.document.RectangleSlot;
import model.document.Slot;
import model.workspace.Document;

public class RectangleState extends State {
	private Point2D start;
	private Point2D end;
	private Slot newSlot;

	public RectangleState(Document doc) {
		super(doc);
	}
	
	public void mousePressed(MouseEvent e, Page p) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			start = e.getPoint();
		}
	}
	
	public void mouseDragged(MouseEvent e, Page p) {
		end = e.getPoint();
		
		Point2D realStart = (Point2D)start.clone();
		Point2D realEnd = (Point2D)end.clone();
		
		realStart.setLocation(Math.min(start.getX(), end.getX()), 
				Math.min(start.getY(), end.getY()));
		realEnd.setLocation(Math.max(start.getX(), end.getX()), 
				Math.max(start.getY(), end.getY()));
		
		Dimension size = new Dimension();
		size.setSize(realEnd.getX() - realStart.getX(), realEnd.getY() - realStart.getY());
		
		if(newSlot == null) {
			newSlot = new RectangleSlot(realStart, size);
			p.addSlot(newSlot);
		}
		else {
			newSlot.setPosition(realStart);
			newSlot.setSize(size);
		}
	}
	
	public void mouseReleased(MouseEvent e, Page p) {
		newSlot = null;
	}
}
