package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;

public class RenameAction extends AbstractAction {
	
	public RenameAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.loadSmallIcon("ikonice/rename.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.loadBigIcon("ikonice/rename.png"));
		putValue(NAME, "Rename");
		putValue(SHORT_DESCRIPTION, "Rename an object.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getWorkspaceTree().startEditing();
	}

}
