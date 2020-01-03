package designmode.controller;

import document.model.Slot;
import document.view.MainPageView;

public class DeleteSlotCommand extends AbstractCommand {
	private MainPageView pageView;
	private Slot slot;
	
	public DeleteSlotCommand(MainPageView pageView, Slot slot) {
		this.pageView=pageView;
		this.slot=slot;
	}

	@Override
	public void doCommand() {
		pageView.getPage().removeSlot(slot);
	}

	@Override
	public void undoCommand() {
		pageView.getPage().addSlot(slot);
	}

}
