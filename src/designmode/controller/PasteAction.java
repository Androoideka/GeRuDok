package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import document.model.Slot;
import document.view.MainPageView;
import exceptionhandling.ExceptionHandler;
import helpers.ImageResizer;
import view.MainFrame;
import view.NoSelectedSlotsException;

public class PasteAction extends AbstractAction {
	public PasteAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/paste.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/paste.png"));
		putValue(NAME, "Paste");
		putValue(SHORT_DESCRIPTION, "Paste copied or cut objects.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			ArrayList<Slot> slots=((MainPageView)MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView()).getSelectionModel().getSlots();
			if(slots==null) {
				throw new NoSelectedSlotsException();
			}
			MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().paste();
		}catch (Exception e) {
			ExceptionHandler.createDialog(e);
		}
	}
}
