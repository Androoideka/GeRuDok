package designmode.controller;

import java.awt.geom.Point2D;

import document.model.Slot;

public class MoveSlotCommand extends AbstractCommand {
	private Slot slot;
	private Point2D position;
	private Point2D startPoz;
	
	public MoveSlotCommand(Slot slot, Point2D position, Point2D start) {
		this.slot=slot;
		this.position=position;
		this.startPoz=start;
	}
	
	@Override
	public void doCommand() {
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
		Point2D prevPosition=new Point2D.Double(pozX, pozY);
		slot.setPosition(prevPosition);
	}
	
	public void setSlot(Slot s) {
		this.slot=s;
	}
	
	public void setPosition(Point2D pos) {
		this.position=pos;
	}
}
