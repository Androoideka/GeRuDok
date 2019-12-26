package document.model;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import designmode.model.CircleSlotPainter;
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
			if(sizeBoth - distanceX - distanceY < 25) return;
			x += distanceX;
			y += distanceX;
			x += distanceY;
			y += distanceY;
			sizeBoth -= distanceX;
			sizeBoth -= distanceY;
		}
		if(h == Handle.SOUTHWEST){
			if(sizeBoth - distanceX < 25) return;
			x += distanceX;
			sizeBoth -= distanceX;
		}
		if(h == Handle.NORTHEAST){
			if(sizeBoth - distanceY < 25) return;
			y += distanceY;
			sizeBoth -= distanceY;
		}
		if(h == Handle.SOUTHEAST){
			if(sizeBoth + distanceX + distanceY < 25) return;
			sizeBoth += distanceX;
			sizeBoth += distanceY;
		}
		
		position.setLocation(x, y);
		size.setSize(sizeBoth, sizeBoth);
		this.getSlotPainter().recalcShape(this);
		notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}
}
