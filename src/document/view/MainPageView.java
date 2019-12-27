package document.view;

import designmode.controller.PageController;
import designmode.model.PageSelectionModel;
import designmode.model.StateManager;
import document.model.Page;

public class MainPageView extends PageView {
	private StateManager stateManager = new StateManager(this);
	private PageSelectionModel pageSelectionModel = new PageSelectionModel();

	public MainPageView(Page page) {
		super(page);
		
		PageController pc = new PageController();
		this.addMouseListener(pc);
		this.addMouseMotionListener(pc);
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}
	
	public PageSelectionModel getSelectionModel() {
		return pageSelectionModel;
	}
}
