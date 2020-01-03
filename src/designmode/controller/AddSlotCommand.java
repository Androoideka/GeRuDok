package designmode.controller;

import document.model.Slot;
import document.view.MainPageView;

public class AddSlotCommand extends AbstractCommand {
	private MainPageView pageView;
	private Slot newSlot;
	
	public AddSlotCommand(MainPageView pageView, Slot newSlot) {
		this.pageView=pageView;
		this.newSlot=newSlot;
	}

	@Override
	public void doCommand() {
		pageView.getPage().addSlot(newSlot);
	}

	@Override
	public void undoCommand() {
		pageView.getPage().removeSlot(newSlot);
	}

}
