package gui.painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import model.document.Slot;

public abstract class SlotPainter {
	
	protected Shape shape;
	
	public void paint(Graphics2D g, Slot slot){
		g.setStroke(slot.getStroke());
		g.draw(shape);
		g.setPaint(slot.getPaint());
		g.fill(shape);
		
		/*g.setPaint(Color.BLACK);
		g.drawString(slot.getName(), 
				(int)slot.getPosition().getX()+10, (int)slot.getPosition().getY()+10);*/
	}
	
	public boolean elementAt(Point pos){
		return shape.contains(pos);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
