package model.document;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import gui.painters.RectangleSlotPainter;

public class RectangleSlot extends Slot {

	public RectangleSlot(Paint paint, Stroke stroke, Dimension size, Point2D position, Color strokeColour) {
		super(paint, stroke, size, position, strokeColour);
		slotPainter = new RectangleSlotPainter(this);
	}

	public static Slot create(Point2D start, Point2D end) {
		Paint fill = Color.WHITE;
		
		Dimension size = new Dimension();
		size.setSize(Math.abs(start.getX() - end.getX()),
				Math.abs(start.getY() - end.getY()));
		BasicStroke stroke = new BasicStroke(thickness, cap, join);
		
		RectangleSlot slot = new RectangleSlot(fill, stroke, size, start, Color.BLACK);
		return slot;
	}
}
