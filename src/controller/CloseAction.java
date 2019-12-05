package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import gui.WorkspaceTabbedMenu;
import helpers.ImageResizer;

public class CloseAction extends AbstractAction {

	public CloseAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/tabclose.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/tabclose.png"));
		putValue(NAME, "Close");
		putValue(SHORT_DESCRIPTION, "Close the currently displayed tab.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WorkspaceTabbedMenu wtb=MainFrame.getInstance().getWorkspaceTabbedMenu();
		wtb.closeDocument();
	}
}
