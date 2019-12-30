package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import designmode.model.PageSlotSelection;
import document.model.Slot;
import document.view.MainPageView;
import exceptionhandling.ExceptionHandler;
import helpers.ImageResizer;
import view.MainFrame;
import view.NoSelectedSlotsException;

public class CutAction extends AbstractAction {
	
	public CutAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/cut.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/cut.png"));
		putValue(NAME, "Cut");
		putValue(SHORT_DESCRIPTION, "Cut selected objects.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			ArrayList<Slot> slots=((MainPageView)MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView()).getSelectionModel().getSlots();
			if(slots==null) {
				throw new NoSelectedSlotsException();
			}
			if(!((((MainPageView)MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView()).getSelectionModel().getNumberOfSlots())==0)) {
				PageSlotSelection contents=new PageSlotSelection(slots);
				MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
				MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getStateManager().setDeleteState();
			}
		}catch (Exception e) {
			ExceptionHandler.createDialog(e);
		}
	}

}
