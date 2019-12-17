package gui.painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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
		
		if(slot.isSelected() || slot.isRotatable()) {
			paintSelection(g2, slot);
		}
	}
	
	private void paintSelection(Graphics2D g, Slot slot) {
		g.setPaint(Color.BLACK);
		g.setStroke(new BasicStroke((float)1, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
		
		//g.drawRect((int)slot.getPosition().getX(), (int)slot.getPosition().getY(),
				//(int)slot.getSize().getWidth(), (int)slot.getSize().getHeight());
		if(slot.isSelected()) {
			System.out.println("dakako");
			for(Handle h : Handle.values()) {
				Point2D position = slot.getHandlePoint(slot.getPosition(), slot.getSize(), h);
				double size = Handle.handleSize;
				g.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2,
						size, size));
			}
		}
		if(slot.isRotatable()) {
			System.out.println("jesje");
			for(Handle h : Handle.values()) {
				if(h==Handle.NORTHEAST || h==Handle.NORTHWEST || h==Handle.SOUTHEAST || h==Handle.SOUTHWEST) {
					Point2D position = slot.getHandlePoint(slot.getPosition(), slot.getSize(), h);
					double size = Handle.handleSize;
					g.fill(new Ellipse2D.Double(position.getX(), position.getY(), size, size));
				}
			}
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
