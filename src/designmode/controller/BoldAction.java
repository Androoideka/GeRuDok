package designmode.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import designmode.view.TextEditor;
import helpers.ImageResizer;
import view.MainFrame;

public class BoldAction extends AbstractAction {
	private TextEditor te;

	public BoldAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("bold.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("bold.png"));
		putValue(NAME, "Bold");
		putValue(SHORT_DESCRIPTION, "Bold selected text.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		te = MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getSelectionModel()
				.getSlots().get(0).getTextEditor();
		te.setFontStyle(Font.BOLD);
	}
}
