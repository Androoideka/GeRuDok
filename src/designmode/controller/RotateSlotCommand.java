package designmode.controller;

import document.model.Slot;

public class RotateSlotCommand extends AbstractCommand {
	private Slot slot;
	private double angle;

	@Override
	public void doCommand() {
		slot.setAngle(angle);
	}

	@Override
	public void undoCommand() {
		slot.setAngle(-angle);
	}

}
