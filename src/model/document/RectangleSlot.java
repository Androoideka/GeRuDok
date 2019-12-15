package model.document;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import gui.painters.RectangleSlotPainter;

public class RectangleSlot extends Slot {

	public RectangleSlot(Paint paint, Stroke stroke, Dimension size, Point position) {
		super(paint, stroke, size, position);
		slotPainter = new RectangleSlotPainter(this);
	}
}
