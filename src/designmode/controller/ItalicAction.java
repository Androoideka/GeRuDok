package designmode.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import designmode.view.TextEditor;
import helpers.ImageResizer;
import view.MainFrame;

public class ItalicAction extends AbstractAction {
	private TextEditor te;
	
	public ItalicAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("italic.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("italic.png"));
		putValue(NAME, "Italic");
		putValue(SHORT_DESCRIPTION, "Set selected text to be italic.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		te=MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getSelectionModel().getSlots().get(0).getTextEditor();
		te.setFontStyle(Font.ITALIC);
	}

}
