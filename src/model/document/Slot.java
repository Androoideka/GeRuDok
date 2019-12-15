package model.document;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import gui.painters.SlotPainter;
import model.workspace.ModelElement;

public abstract class Slot extends ModelElement {
	
	protected static float thickness = 2f;
	protected static int cap = BasicStroke.CAP_SQUARE;
	protected static int join = BasicStroke.JOIN_BEVEL;
	
	protected Paint paint;
	protected Stroke stroke;
	protected Color strokeColour;
	
	protected Dimension size;
	protected Point2D position;
	
	protected SlotPainter slotPainter;
	
	public Slot(Paint paint, Stroke stroke, Dimension size, Point2D position, Color strokeColour) {
		super();
		this.paint = paint;
		this.stroke = stroke;
		this.size = size;
		this.position = position;
		this.strokeColour = strokeColour;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public Color getStrokeColour() {
		return strokeColour;
	}

	public void setStrokeColour(Color strokeColour) {
		this.strokeColour = strokeColour;
	}

	public SlotPainter getSlotPainter() {
		return slotPainter;
	}
}
