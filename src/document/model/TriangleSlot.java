package document.model;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import designmode.model.Handle;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class TriangleSlot extends Slot {
	public TriangleSlot(Point2D position, Dimension size) {
		super(position, size);
		slotPainter=new TriangleSlotPainter(this);
	}
	
	@Override
	public void scale(Handle h, double distanceX, double distanceY) {
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

	@Override
	public Slot clone() {
		return new TriangleSlot(this.getPosition(), this.getSize());
	}
}
