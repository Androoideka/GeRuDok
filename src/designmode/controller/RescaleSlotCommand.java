package designmode.controller;

import designmode.model.Handle;
import document.model.Slot;

public class RescaleSlotCommand extends AbstractCommand {
	private Slot slot;
	private Handle selectedHandle;
	private double distanceX;
	private double distanceY;
	
	public RescaleSlotCommand(Slot slot, Handle selectedHandle, double distanceX, double distanceY) {
		this.slot=slot;
		this.selectedHandle=selectedHandle;
		this.distanceX=distanceX;
		this.distanceY=distanceY;
	}

	@Override
	public void doCommand() {
		slot.scale(selectedHandle, distanceX, distanceY);
	}

	@Override
	public void undoCommand() {
		slot.scale(selectedHandle, -distanceX, -distanceY);
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
