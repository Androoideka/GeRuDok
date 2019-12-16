package model.document;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import gui.painters.CircleSlotPainter;

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
}
