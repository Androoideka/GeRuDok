package gui.painters;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.io.Serializable;

import model.document.Slot;

public abstract class SlotPainter implements Serializable {
	
	protected Shape shape;
	
	public void paint(Graphics2D g, Slot slot){
		//Kreirana kopija da ne bi menjala granicu panela
		Graphics2D g2 = (Graphics2D)g.create();
		
		g2.setPaint(slot.getStrokeColour());
		g2.setStroke(slot.getStroke());
		g2.draw(shape);
		if(slot.getPaint() != null) {
			g2.setPaint(slot.getPaint());
			g2.fill(shape);
		}
	}
	
	public abstract void recalcShape(Slot slot);
	
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
