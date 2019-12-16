package model.document;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import gui.painters.CircleSlotPainter;

public class CircleSlot extends Slot {
	public CircleSlot(Point2D position, Dimension size) {
		super(position, size);
		slotPainter=new CircleSlotPainter(this);
	}
	
	public static Slot create(Point2D center, Point2D end) {
		Dimension size=new Dimension();
		size.setSize(Math.abs(center.getX() - end.getX()),
				Math.abs(center.getY() - end.getY()));
		//size.setSize(center.distance(end), center.distance(end));
		CircleSlot slot = new CircleSlot(center, size);
		return slot;
	}
}
