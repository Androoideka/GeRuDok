package designmode.model;

import java.awt.geom.Ellipse2D;

import document.model.CircleSlot;
import document.model.Slot;

public class CircleSlotPainter extends SlotPainter {
	public CircleSlotPainter(Slot slot) {
		CircleSlot circle=(CircleSlot)slot;
		recalcShape(circle);
	}
	
	public void recalcShape(Slot slot) {
		shape=new Ellipse2D.Float((float)slot.getPosition().getX(), (float)slot.getPosition().getY(), (float)slot.getSize().getWidth(), (float)slot.getSize().getHeight());
	}
}
