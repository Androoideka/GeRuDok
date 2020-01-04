package designmode.controller;

import document.model.Slot;

public class RotateSlotCommand extends AbstractCommand {
	private Slot slot;
	private double angle;
	
	public RotateSlotCommand(Slot slot, double angle) {
		this.slot=slot;
		this.angle=angle;
	}

	@Override
	public void doCommand() {
		slot.setAngle(angle);
	}

	@Override
	public void undoCommand() {
		slot.setAngle(-angle);
	}

	public void setSlot(Slot s) {
		this.slot=s;
	}
	
	public void setAngle(double a) {
		this.angle=a;
	}
}
