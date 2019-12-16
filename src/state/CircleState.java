package state;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import model.document.CircleSlot;
import model.document.Page;
import model.document.Slot;
import model.workspace.Document;

public class CircleState extends State {
	private Point2D center;
	private Point2D end;
	private Slot newSlot;
	
	public CircleState(Document doc) {
		super(doc);
	}
	
	public void mousePressed(MouseEvent e, Page p) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			center=e.getPoint();
		}
	}
	
	public void mouseDragged(MouseEvent e, Page p) {
		end=e.getPoint();
		
		Point2D realStart = (Point2D)center.clone();
		Point2D realEnd = (Point2D)end.clone();
		
		realStart.setLocation(Math.min(center.getX(), end.getX()), 
				Math.min(center.getY(), end.getY()));
		realEnd.setLocation(Math.max(center.getX(), end.getX()), 
				Math.max(center.getY(), end.getY()));
		
		p.removeSlot(newSlot);
		newSlot = CircleSlot.create(realStart, realEnd);
		p.addSlot(newSlot);
	}
	
	public void mouseReleased(MouseEvent e, Page p) {
		newSlot=null;
	}
}
