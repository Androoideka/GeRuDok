package model.document;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import gui.painters.TriangleSlotPainter;

public class TriangleSlot extends Slot {
	public TriangleSlot(Point2D position, Dimension size) {
		super(position, size);
		slotPainter=new TriangleSlotPainter(this);
	}
	
	public TriangleSlot(Paint paint, Stroke stroke, Dimension size, Point2D position, Color strokeColour) {
		super(paint, stroke, size, position, strokeColour);
		slotPainter = new TriangleSlotPainter(this);
	}
	
	public static Slot create(Point2D start, Point2D end) {
		Dimension size = new Dimension();
		size.setSize(Math.abs(start.getX() - end.getX()), Math.abs(start.getY() - end.getY()));
		TriangleSlot slot = new TriangleSlot(start, size);
		return slot;
	}
}
