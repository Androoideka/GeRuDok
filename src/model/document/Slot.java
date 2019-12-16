package model.document;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

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
}
