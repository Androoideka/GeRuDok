package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.DocumentView;
import gui.MainFrame;
import gui.PageView;
import helpers.ImageResizer;

public class RectangleAction extends AbstractAction {

	public RectangleAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_C, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/rectangle.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/rectangle.png"));
		putValue(NAME, "Create rectangle");
		putValue(SHORT_DESCRIPTION, "Create rectangular slots on the canvas.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DocumentView docView = MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView();
		if(docView != null) {
			docView.getDocument().setRectangleState();
		}
	}
}
