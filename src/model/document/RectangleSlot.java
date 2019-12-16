package model.document;

import java.awt.Dimension;

import java.awt.geom.Point2D;

import gui.painters.Handle;
import gui.painters.RectangleSlotPainter;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class RectangleSlot extends Slot {
	
	public RectangleSlot(Point2D position, Dimension size) {
		super(position, size);
		slotPainter = new RectangleSlotPainter(this);
	}
	
	public static Slot create(Point2D start, Point2D end) {
		Dimension size = new Dimension();
		size.setSize(Math.abs(start.getX() - end.getX()),
				Math.abs(start.getY() - end.getY()));
		RectangleSlot slot = new RectangleSlot(start, size);
		return slot;
	}
	
	@Override
	public void scale(Handle h, double distanceX, double distanceY) {
		System.out.println("test");
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
		
		position.setLocation(x, y);
		size.setSize(sizeX, sizeY);
		this.getSlotPainter().recalcShape(this);
		notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}
}
