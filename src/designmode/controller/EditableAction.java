package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;

public class EditableAction extends AbstractAction {
	
	public EditableAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("editable.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("editable.png"));
		putValue(NAME, "Edit");
		putValue(SHORT_DESCRIPTION, "Enable text editing.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("WOOOO");
		JTextPane tp=MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getSelectionModel().getSlots().get(0).getTextEditor().getTP();
		tp.setEditable(true);
	}

}
