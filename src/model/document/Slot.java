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
	protected static float thickness = 2f;
	protected static int cap = BasicStroke.CAP_SQUARE;
	protected static int join = BasicStroke.JOIN_BEVEL;
	protected static Color currentStrokeColour = Color.BLACK;
	protected static Color currentPaint = null;

	protected Paint paint;
	protected Stroke stroke;
	protected Color strokeColour;
	
	protected Dimension size;
	protected Point2D position;
	
	protected SlotPainter slotPainter;
	
	protected boolean selected = false;
	
	public Slot(Paint paint, Stroke stroke, Dimension size, Point2D position, Color strokeColour) {
		super();
		this.paint = paint;
		this.stroke = stroke;
		this.size = size;
		this.position = position;
		this.strokeColour = strokeColour;
	}
	
	public Slot(Point2D position, Dimension size) {
		super();
		this.position = position;
		this.size = size;
		
		this.stroke = new BasicStroke(thickness, cap, join);
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
			return stroke;
		}
		return new BasicStroke(thickness, cap, join, 0, new float[] {9}, 0);
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.RENAME));
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
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
