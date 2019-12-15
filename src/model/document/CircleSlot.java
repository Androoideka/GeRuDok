package model.document;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import gui.painters.CircleSlotPainter;

public class CircleSlot extends Slot {
	public CircleSlot(Point2D position, Dimension size) {
		super(position, size);
		slotPainter=new CircleSlotPainter(this);
	}
	
	public CircleSlot(Paint paint, Stroke stroke, Dimension size, Point2D position, Color strokeColour) {
		super(paint, stroke, size, position, strokeColour);
		slotPainter = new CircleSlotPainter(this);
	}
	
	public static Slot create(Point2D center, Point2D end) {
		Dimension size=new Dimension();
		size.setSize(Math.abs(center.getX() - end.getX()), Math.abs(center.getY() - end.getY()));
		CircleSlot slot = new CircleSlot(center, size);
		return slot;
	}
}
