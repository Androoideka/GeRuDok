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

}
