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
		p.removeSlot(newSlot);
		newSlot = CircleSlot.create(center, end);
		p.addSlot(newSlot);
	}
	
	public void mouseReleased(MouseEvent e, Page p) {
		newSlot=null;
	}
}
