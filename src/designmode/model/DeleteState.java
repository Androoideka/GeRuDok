package designmode.model;

import document.model.Slot;
import document.view.MainPageDrawer;

public class DeleteState extends State {

	public DeleteState(MainPageDrawer pageView) {
		super(pageView);
	}
	
	public void deleteSlot(Slot selectedSlot) {
		if(pageView.getPage() != null) {
			pageView.getPage().removeSlot(selectedSlot);
		}
		pageView.getStateManager().setSelectState();
	}
}
