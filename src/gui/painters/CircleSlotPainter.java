package gui.painters;

import java.awt.geom.Ellipse2D;

import model.document.CircleSlot;
import model.document.Slot;

public class CircleSlotPainter extends SlotPainter {
	public CircleSlotPainter(Slot slot) {
		CircleSlot circle=(CircleSlot)slot;
		shape=new Ellipse2D.Float((float)circle.getPosition().getX(), (float)circle.getPosition().getY(), (float)circle.getSize().getWidth(), (float)circle.getSize().getHeight());
	}
}
