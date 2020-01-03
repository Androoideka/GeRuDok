package designmode.model;

import designmode.controller.DeleteSlotCommand;
import document.model.Slot;
import document.view.MainPageView;

public class DeleteState extends State {

	public DeleteState(MainPageView pageView) {
		super(pageView);
	}
	
	public void deleteSlot() {
		if(pageView.getPage() != null) {
			for(Slot slot : pageView.getSelectionModel().getSlots()) {
				pageView.getCommandManager().addCommand(new DeleteSlotCommand(pageView, slot));
			}
		}
		pageView.getStateManager().setSelectState();
	}
}
