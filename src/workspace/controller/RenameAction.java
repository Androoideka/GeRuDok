package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;

public class RenameAction extends AbstractAction {
	
	public RenameAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("rename.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("rename.png"));
		putValue(NAME, "Rename");
		putValue(SHORT_DESCRIPTION, "Rename an object.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getWorkspaceTree().startEditing();
	}

}
