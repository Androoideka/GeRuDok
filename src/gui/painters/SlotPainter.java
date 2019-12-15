package gui.painters;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;

import model.document.Slot;

public abstract class SlotPainter {
	
	protected Shape shape;
	
	public void paint(Graphics2D g, Slot slot){
		g.setPaint(slot.getStrokeColour());
		g.setStroke(slot.getStroke());
		g.draw(shape);
		g.setPaint(slot.getPaint());
		g.fill(shape);
	}
	
	public boolean isWithinSlot(Point2D position){
		return shape.contains(position);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
