package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;

public class RedoAction extends AbstractAction {
	
	public RedoAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_Y, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/redo.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/redo.png"));
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redo your last undone action.");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getCommandManager().doCommand();
	}

}
