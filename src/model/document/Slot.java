package model.document;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import gui.painters.SlotPainter;
import model.workspace.ModelElement;

public class Slot extends ModelElement {
	
	protected Paint paint;
	protected Stroke stroke;
	
	protected Dimension size;
	protected Point position;
	
	protected SlotPainter slotPainter;
	
	public Slot(Paint paint, Stroke stroke, Dimension size, Point position) {
		super();
		this.paint = paint;
		this.stroke = stroke;
		this.size = size;
		this.position = position;
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

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public SlotPainter getSlotPainter() {
		return slotPainter;
	}
}
