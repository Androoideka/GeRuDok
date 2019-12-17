package model.document;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import gui.painters.Handle;
import gui.painters.SlotPainter;
import model.workspace.ModelElement;
import observer.ObserverEventType;
import observer.ObserverNotification;

public abstract class Slot extends ModelElement {
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
	protected double angle;
	
	protected SlotPainter slotPainter;
	
	protected boolean selected = false;
	
	public Slot(Point2D position, Dimension size) {
		super();
		this.position = position;
		this.size = size;
		this.angle=0;
		
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
		return new BasicStroke(thickness, cap, join);
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
	
	public double getAngle() {
		return angle;
	}
	
	public void setAngle(double angle) {
		this.angle=angle;
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
	
	public Handle getHandleForPoint(Point2D point) {
		if(selected) {
			for(Handle h : Handle.values()) {
				Point2D handleCenter = this.getHandlePoint(position, size, h);
				if(handleCenter.distance(point) <= (double)Handle.handleSize) {
					return h;
				}
			}
		}
		return null;
	}
	
	public Point2D getHandlePoint(Point2D position, Dimension size, Handle handlePosition) {
		double x=0, y=0;
		
		if(handlePosition == Handle.NORTHWEST || handlePosition == Handle.NORTH || handlePosition == Handle.NORTHEAST){
			y = position.getY();
		}
		if(handlePosition == Handle.EAST || handlePosition == Handle.WEST){
			y = position.getY()+size.getHeight()/2;
		}
		if(handlePosition == Handle.SOUTHWEST || handlePosition == Handle.SOUTH || handlePosition == Handle.SOUTHEAST){
			y = position.getY() + size.getHeight();
		}
		if(handlePosition == Handle.NORTHWEST || handlePosition == Handle.WEST || handlePosition == Handle.SOUTHWEST){
			x = position.getX();
		}
		if(handlePosition == Handle.NORTH || handlePosition == Handle.SOUTH){
			x = position.getX() + size.getWidth()/2;
		}
		if(handlePosition == Handle.NORTHEAST || handlePosition == Handle.EAST || handlePosition == Handle.SOUTHEAST){
			x = position.getX() + size.getWidth();
		}

		return new Point2D.Double(x,y);
	}
	
	public abstract void scale(Handle h, double distanceX, double distanceY);
	
	public void rotate(double angle) {
		this.setAngle(this.angle-angle);
	}
}
