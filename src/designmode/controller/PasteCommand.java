package designmode.controller;

import java.util.ArrayList;

import document.model.Slot;
import view.MainFrame;

public class PasteCommand extends AbstractCommand {
	private ArrayList<Slot> slots;
	
	public PasteCommand(ArrayList<Slot> slots) {
		this.slots=slots;
	}
	
	@Override
	public void doCommand() {
		MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().paste();
	}

	@Override
	public void undoCommand() {
		for (Slot slot : slots) {
			MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getPage().removeSlot(slot);
		}
	}
}
