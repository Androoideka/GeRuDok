package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import document.view.DocumentView;
import document.view.MainPageView;
import helpers.ImageResizer;
import view.MainFrame;

public class RectangleAction extends AbstractAction {

	public RectangleAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_C, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("rectangle.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("rectangle.png"));
		putValue(SHORT_DESCRIPTION, "Create rectangular slots on the canvas.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DocumentView docView = MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView();
		if(docView != null) {
			MainPageView mainPageView = docView.getCurrentView();
			mainPageView.getStateManager().setRectangleState();
		}
	}
}
