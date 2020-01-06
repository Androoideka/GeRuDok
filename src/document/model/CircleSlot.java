package document.model;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import designmode.model.Handle;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class CircleSlot extends Slot {
	public CircleSlot(Point2D position, Dimension size) {
		super(position, size);
		slotPainter=new CircleSlotPainter(this);
	}

	@Override
	public void scale(Handle h, double distanceX, double distanceY) {
		double x=position.getX(), y=position.getY(),
			sizeBoth = size.getWidth();
		if(h == Handle.NORTHWEST){
			x += distanceX;
			y += distanceX;
			x += distanceY;
			y += distanceY;
			sizeBoth -= distanceX;
			sizeBoth -= distanceY;
		}
		if(h == Handle.SOUTHWEST){
			x += distanceX;
			sizeBoth -= distanceX;
		}
		if(h == Handle.NORTHEAST){
			y += distanceY;
			sizeBoth -= distanceY;
		}
		if(h == Handle.SOUTHEAST){
			sizeBoth += distanceX;
			sizeBoth += distanceY;
		}
		
		position.setLocation(x, y);
		size.setSize(sizeBoth, sizeBoth);
		this.getSlotPainter().recalcShape(this);
		notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}

	@Override
	public Slot clone() {
		return new CircleSlot(this.getPosition(), this.getSize());
	}
}
