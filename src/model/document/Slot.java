package model.document;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import gui.painters.SlotPainter;
import model.workspace.ModelElement;
import observer.ObserverEventType;
import observer.ObserverNotification;
import state.Handle;

public abstract class Slot extends ModelElement {
	static final int handleSize=8;
	//lose mesto za ove vrednosti, opterecuje klasu
	protected transient static float currentThickness = 2f;
	protected transient static int currentCap = BasicStroke.CAP_SQUARE;
	protected transient static int currentJoin = BasicStroke.JOIN_BEVEL;
	protected transient static Color currentStrokeColour = Color.BLACK;
	protected transient static Color currentPaint = null;
	
	protected float thickness;
	protected int cap;
	protected int join;

	protected Paint paint;
	protected Color strokeColour;
	
	protected Dimension size;
	protected Point2D position;
	
	protected SlotPainter slotPainter;
	
	protected boolean selected = false;
	
	public Slot(Point2D position, Dimension size) {
		super();
		this.position = position;
		this.size = size;
		
		setStroke();
		this.strokeColour = currentStrokeColour;
		this.paint = currentPaint;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}

	public Stroke getStroke() {
		if(!selected) {
			return new BasicStroke(thickness, cap, join);
		}
		return new BasicStroke(currentThickness, currentCap, currentJoin, 0, new float[] {9}, 0);
	}
	
	public void setStroke() {
		this.thickness = currentThickness;
		this.cap = currentCap;
		this.join = currentJoin;
	}
	
	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
		this.slotPainter.recalcShape(this);
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
		this.slotPainter.recalcShape(this);
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}

	public Color getStrokeColour() {
		return strokeColour;
	}

	public void setStrokeColour(Color strokeColour) {
		this.strokeColour = strokeColour;
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}

	public SlotPainter getSlotPainter() {
		return slotPainter;
	}
	
	public void paintHandles(Graphics2D g) {
		if(doc.getStateManager().getCurrentState()==this) {
			g.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1f, new float[] {9, 0}, 0));
			g.setPaint(Color.BLACK);
			g.drawRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int)this.getSize().getWidth(), (int)this.getSize().getHeight());
			for (Handle e : Handle.values()) {
					paintSelectedHandle(getHandlePoint(this.getPosition(), this.getSize(), e));
			}
		}
	}
	
	private void paintSelectedHandle(Graphics2D g, Point2D handlePoint) {
		int size=handleSize;
		g.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2, size, size));
	}

	public Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handle) {
		int x=0, y=0;
		if(handle==Handle.NORTHWEST || handle==Handle.NORTH || handle==Handle.NORTHEAST) {
			y=(int) position.getY();
		}
		if(handle==Handle.EAST || handle==Handle.WEST) {
			y=(int) (position.getY()+size.getHeight());
		}
		if(handle==Handle.SOUTHWEST || handle==Handle.SOUTH || handle==Handle.SOUTHEAST) {
			y=(int) (position.getY()+size.getHeight());
		}
		if(handle==Handle.NORTHWEST || handle==Handle.NORTH || handle==Handle.NORTHEAST) {
			x=(int) position.getX();
		}
		if(handle==Handle.EAST || handle==Handle.WEST) {
			x=(int) (position.getX()+size.getWidth());
		}
		if(handle==Handle.SOUTHWEST || handle==Handle.SOUTH || handle==Handle.SOUTHEAST) {
			x=(int) (position.getX()+size.getWidth());
		}
		return new Point2D.Double(x, y);
	}
}
