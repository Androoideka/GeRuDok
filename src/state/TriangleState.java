package state;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import model.document.Page;
import model.document.Slot;
import model.document.TriangleSlot;
import model.workspace.Document;

public class TriangleState extends State {
	private Point2D start;
	private Point2D end;
	private Slot newSlot;
	
	public TriangleState(Document doc) {
		super(doc);
	}
	
	public void mousePressed(MouseEvent e, Page p) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			start=e.getPoint();
		}
	}
	
	public void mouseDragged(MouseEvent e, Page p) {
		end = e.getPoint();
		Point2D realStart = (Point2D)start.clone();
		Point2D realEnd = (Point2D)end.clone();
		realStart.setLocation(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));
		realEnd.setLocation(Math.max(start.getX(), end.getX()), Math.max(start.getY(), end.getY()));
		p.removeSlot(newSlot);
		newSlot = TriangleSlot.create(realStart, realEnd);
		p.addSlot(newSlot);
	}
	
	public void mouseReleased(MouseEvent e, Page p) {
		newSlot=null;
		doc.getStateManager().setSelectState();
	}
}
