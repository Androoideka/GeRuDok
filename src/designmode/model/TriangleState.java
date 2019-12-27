package designmode.model;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import document.model.Slot;
import document.model.TriangleSlot;
import document.view.MainPageDrawer;

public class TriangleState extends State {
	private Point2D start;
	private Point2D end;
	private Slot newSlot;
	
	public TriangleState(MainPageDrawer pageView) {
		super(pageView);
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			start=e.getPoint();
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		end = e.getPoint();
		Point2D realStart = (Point2D)start.clone();
		Point2D realEnd = (Point2D)end.clone();
		realStart.setLocation(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));
		realEnd.setLocation(Math.max(start.getX(), end.getX()), Math.max(start.getY(), end.getY()));
		
		Dimension size = new Dimension();
		size.setSize(Math.abs(start.getX() - end.getX()), Math.abs(start.getY() - end.getY()));
		
		if(newSlot == null) {
			newSlot = new TriangleSlot(realStart, size);
			pageView.getPage().addSlot(newSlot);
		}
		else {
			newSlot.setPosition(realStart);
			newSlot.setSize(size);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		newSlot=null;
	}
}
