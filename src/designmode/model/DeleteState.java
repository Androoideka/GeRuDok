package designmode.model;

import document.model.Slot;
import document.view.MainPageView;

public class DeleteState extends State {

	public DeleteState(MainPageView pageView) {
		super(pageView);
	}
	
	public void deleteSlot() {
		if(pageView.getPage() != null) {
			for(Slot slot : pageView.getSelectionModel().getSlots()) {
				pageView.getPage().removeSlot(slot);
			}
		}
		pageView.getStateManager().setSelectState();
	}
}
