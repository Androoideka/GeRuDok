package document.model;

import java.awt.geom.Ellipse2D;

public class CircleSlotPainter extends SlotPainter {
	public CircleSlotPainter(Slot slot) {
		CircleSlot circle=(CircleSlot)slot;
		recalcShape(circle);
	}
	
	public void recalcShape(Slot slot) {
		if(slot.getSize().getWidth() < 0) {
			shape=new Ellipse2D.Float((float)(slot.getPosition().getX() + slot.getSize().getWidth()),
					(float)(slot.getPosition().getY() + slot.getSize().getHeight()),
					(float)Math.abs(slot.getSize().getWidth()), (float)Math.abs(slot.getSize().getHeight()));
		}
		else {
			shape=new Ellipse2D.Float((float)slot.getPosition().getX(), (float)slot.getPosition().getY(), (float)slot.getSize().getWidth(), (float)slot.getSize().getHeight());
		}
	}
}
