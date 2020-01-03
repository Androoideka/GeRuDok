package designmode.controller;

import java.awt.geom.Point2D;

import document.model.Slot;

public class MoveSlotCommand extends AbstractCommand {
	private Slot slot;
	private Point2D position;
	private double distanceX;
	private double distanceY;
	
	public MoveSlotCommand(Slot slot, Point2D position, double distanceX, double distanceY) {
		this.slot=slot;
		this.position=position;
		this.distanceX=distanceX;
		this.distanceY=distanceY;
	}
	
	@Override
	public void doCommand() {
		position.setLocation(position.getX() + distanceX, position.getY() + distanceY);
		slot.setPosition(position);
	}
	
	@Override
	public void undoCommand() {
		position.setLocation(position.getX() - distanceX, position.getY() - distanceY);
		slot.setPosition(position);
	}
}
