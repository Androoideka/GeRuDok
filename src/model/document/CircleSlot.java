package model.document;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import gui.painters.CircleSlotPainter;
import gui.painters.Handle;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class CircleSlot extends Slot {
	public CircleSlot(Point2D position, Dimension size) {
		super(position, size);
		slotPainter=new CircleSlotPainter(this);
	}
	
	public static Slot create(Point2D start, double distance) {
		Dimension size=new Dimension();
		size.setSize(distance * 2, distance * 2);
		CircleSlot slot = new CircleSlot(start, size);
		return slot;
	}

	@Override
	public void scale(Handle h, double distanceX, double distanceY) {
		double distance = Math.max(distanceX, distanceY);
		double x=position.getX(), y=position.getY(),
				sizeX = size.getWidth(), sizeY = size.getHeight();
		
		if(h == Handle.NORTHWEST){
			x += distance;
			sizeX -= distance;
			y += distance;
			sizeY -= distance;
		}
		if(h == Handle.SOUTHWEST){
			x += distance;
			sizeX -= distance;
			sizeY -= distance;
		}
		if(h == Handle.NORTHEAST){
			sizeX -= distance;
			y += distance;
			sizeY -= distance;
		}
		if(h == Handle.SOUTHEAST){
			sizeX += distance;
			sizeY += distance;
		}
		
		position.setLocation(x, y);
		size.setSize(sizeX, sizeY);
		this.getSlotPainter().recalcShape(this);
		notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}
}
