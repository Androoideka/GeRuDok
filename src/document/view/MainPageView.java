package document.view;

import java.awt.datatransfer.Transferable;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import designmode.controller.CommandManager;
import designmode.controller.PageController;
import designmode.model.PageSelectionModel;
import designmode.model.PageSlotSelection;
import designmode.model.StateManager;
import document.model.CircleSlot;
import document.model.CircleSlotPainter;
import document.model.Page;
import document.model.RectangleSlot;
import document.model.RectangleSlotPainter;
import document.model.Slot;
import document.model.TriangleSlotPainter;
import exceptionhandling.ExceptionHandler;
import view.MainFrame;

public class MainPageView extends PageView {
	private StateManager stateManager = new StateManager(this);
	private PageSelectionModel pageSelectionModel = new PageSelectionModel();
	private CommandManager commandManager = new CommandManager();

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
	
	public CommandManager getCommandManager() {
		return commandManager;
	}
	
	public void paste() {
		Transferable clipboardContent=MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
		if(clipboardContent!=null && clipboardContent.isDataFlavorSupported(PageSlotSelection.slotFlavor)){
			try {
				Slot slot=null;
				@SuppressWarnings("unchecked")
				ArrayList<Slot> slots=(ArrayList<Slot>)clipboardContent.getTransferData(PageSlotSelection.slotFlavor);
				for(int i=0;i<slots.size();i++) {
					if(slots.get(i) instanceof Slot) {
						slot=slots.get(i).clone();
						Point2D newLocation=(Point2D)slot.getPosition().clone();
						//PointerInfo pi=MouseInfo.getPointerInfo();
						//Point2D p=pi.getLocation();
						//newLocation.setLocation(p);
						newLocation.setLocation(slot.getPosition().getX()+20, slot.getPosition().getY()+20);
						slot.setPosition(newLocation);
						if(slot instanceof RectangleSlot) {
							slot.setSlotPainter(new RectangleSlotPainter(slot));
						}else if(slot instanceof CircleSlot) {
							slot.setSlotPainter(new CircleSlotPainter(slot));
						}else {
							slot.setSlotPainter(new TriangleSlotPainter(slot));
						}
						page.addSlot(slot);
					}
				}
			}catch(Exception e) {
				ExceptionHandler.createDialog(e);
			}
		}
	}
}
