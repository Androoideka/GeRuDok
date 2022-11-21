package document.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import document.view.WorkspaceTabbedMenu;
import helpers.ImageResizer;
import view.MainFrame;

public class CloseAction extends AbstractAction {

	public CloseAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("tabclose.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("tabclose.png"));
		putValue(NAME, "Close");
		putValue(SHORT_DESCRIPTION, "Close the currently displayed tab.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WorkspaceTabbedMenu wtb=MainFrame.getInstance().getWorkspaceTabbedMenu();
		wtb.closeDocument();
	}
}
