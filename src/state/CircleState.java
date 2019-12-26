package state;

import java.awt.Dimension;
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
		
		double distance = Math.max(Math.abs(center.getX() - end.getX()),
				Math.abs(center.getY() - end.getY()));;
		
		realStart.setLocation(center.getX() - distance, 
				center.getY() - distance);
		
		Dimension size=new Dimension();
		size.setSize(distance * 2, distance * 2);
		
		if(newSlot == null) {
			newSlot = new CircleSlot(realStart, size);
			p.addSlot(newSlot);
		}
		else {
			newSlot.setPosition(realStart);
			newSlot.setSize(size);
		}
	}
	
	public void mouseReleased(MouseEvent e, Page p) {
		newSlot=null;
	}
}
