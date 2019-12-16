package gui.painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import model.document.Slot;
import state.Handle;

public abstract class SlotPainter implements Serializable {
	static final int handleSize=8;

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
	
	public void paintHandles(Graphics2D g, Slot s) {
		if(s.isSelected()==true) {
			g.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1f, new float[] {9, 0}, 0));
			g.setPaint(Color.BLACK);
			g.drawRect((int)s.getPosition().getX(), (int)s.getPosition().getY(), (int)s.getSize().getWidth(), (int)s.getSize().getHeight());
			for (Handle h : Handle.values()) {
					paintSelectedHandle(g, s, getHandlePoint(s.getPosition(), s.getSize(), h, s));
			}
		}
	}
	
	private void paintSelectedHandle(Graphics2D g, Slot s, Point2D handlePoint) {
		int size=handleSize;
		g.fill(new Rectangle2D.Double(s.getPosition().getX()-size/2, s.getPosition().getY()-size/2, size, size));
	}

	public Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handle, Slot s) {
		int x=0, y=0;
		if(handle==Handle.NORTHWEST || handle==Handle.NORTH || handle==Handle.NORTHEAST) {
			y=(int) s.getPosition().getY();
		}
		if(handle==Handle.EAST || handle==Handle.WEST) {
			y=(int) (s.getPosition().getY()+size.getHeight());
		}
		if(handle==Handle.SOUTHWEST || handle==Handle.SOUTH || handle==Handle.SOUTHEAST) {
			y=(int) (s.getPosition().getY()+size.getHeight());
		}
		if(handle==Handle.NORTHWEST || handle==Handle.NORTH || handle==Handle.NORTHEAST) {
			x=(int) s.getPosition().getX();
		}
		if(handle==Handle.EAST || handle==Handle.WEST) {
			x=(int) (s.getPosition().getX()+size.getWidth());
		}
		if(handle==Handle.SOUTHWEST || handle==Handle.SOUTH || handle==Handle.SOUTHEAST) {
			x=(int) (s.getPosition().getX()+size.getWidth());
		}
		return new Point2D.Double(x, y);
	}
}
