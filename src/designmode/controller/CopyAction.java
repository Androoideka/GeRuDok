package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import designmode.model.PageSlotSelection;
import document.model.Slot;
import document.view.MainPageView;
import exceptions.ExceptionHandler;
import exceptions.NoSelectedSlotsException;
import helpers.ImageResizer;
import view.MainFrame;

public class CopyAction extends AbstractAction {

	public CopyAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/copy.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/copy.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy selected objects.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			ArrayList<Slot> slots = ((MainPageView) MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView()
					.getCurrentView()).getSelectionModel().getSlots();
			if (slots == null) {
				throw new NoSelectedSlotsException();
			}
			if (!((((MainPageView) MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView())
					.getSelectionModel().getNumberOfSlots()) == 0)) {
				PageSlotSelection contents = new PageSlotSelection(slots);
				MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
			}
		} catch (NoSelectedSlotsException e) {
			ExceptionHandler.createMessageDialog(e);
		}
	}

}
