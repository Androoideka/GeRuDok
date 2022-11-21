package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;

public class UndoAction extends AbstractAction {
	
	public UndoAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("undo.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("undo.png"));
		putValue(NAME, "Undo");
		putValue(SHORT_DESCRIPTION, "Undo your last action.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getCommandManager().undoCommand();
	}

}
