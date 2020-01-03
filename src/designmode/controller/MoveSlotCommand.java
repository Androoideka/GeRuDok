package designmode.controller;

import java.awt.geom.Point2D;

import document.model.Slot;

public class MoveSlotCommand extends AbstractCommand {
	private Slot slot;
	private Point2D position;
	private double distanceX;
	private double distanceY;
	private Point2D startPoz;
	
	public MoveSlotCommand(Slot slot, Point2D position, double distanceX, double distanceY, Point2D start) {
		this.slot=slot;
		this.position=position;
		this.distanceX=distanceX;
		this.distanceY=distanceY;
		this.startPoz=start;
	}
	
	@Override
	public void doCommand() {
		position.setLocation(position.getX() + distanceX, position.getY() + distanceY);
		slot.setPosition(position);
	}
	
	@Override
	public void undoCommand() {
		double pomerajX, pomerajY;
		pomerajX=Math.abs(position.getX()-startPoz.getX());
		pomerajY=Math.abs(position.getY()-startPoz.getY());
		double pozX=position.getX();
		double pozY=position.getY();
		if(position.getX()>startPoz.getX()) {
			pozX-=pomerajX;
		}else {
			pozX+=pomerajX;
		}
		if(position.getY()>startPoz.getY()) {
			pozY-=pomerajY;
		}else {
			pozY+=pomerajY;
		}
		position.setLocation(pozX, pozY);
		slot.setPosition(position);
	}
	
	public void setSlot(Slot s) {
		this.slot=s;
	}
	
	public void setPosition(Point2D pos) {
		this.position=pos;
	}
	
	public void setDistanceX(double dx) {
		this.distanceX=dx;
	}
	
	public void setDistanceY(double dy) {
		this.distanceY=dy;
	}
}
