package designmode.controller;

import designmode.model.Handle;
import document.model.Slot;

public class RescaleSlotCommand extends AbstractCommand {
	private Slot slot;
	private Handle selectedHandle;
	private double distanceX;
	private double distanceY;
	private double undoX;
	private double undoY;
	
	public RescaleSlotCommand(Slot slot, Handle selectedHandle, double distanceX, double distanceY) {
		this.slot=slot;
		this.selectedHandle=selectedHandle;
		this.distanceX=distanceX;
		this.distanceY=distanceY;
		this.undoX=distanceX;
		this.undoY=distanceY;
	}

	@Override
	public void doCommand() {
		slot.scale(selectedHandle, distanceX, distanceY);
		undoX+=distanceX;
		undoY+=distanceY;
	}

	@Override
	public void undoCommand() {
		slot.scale(selectedHandle, -undoX, -undoY);
	}
	
	public void setSlot(Slot s) {
		this.slot=s;
	}
	
	public void setSelectedHandle(Handle h) {
		this.selectedHandle=h;
	}
	
	public void setDistanceX(double dx) {
		this.distanceX=dx;
	}
	
	public void setDistanceY(double dy) {
		this.distanceY=dy;
	}
}
