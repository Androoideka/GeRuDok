package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import gui.MainFrame;
import model.workspace.Document;
import model.workspace.Project;
import model.workspace.Workspace;

public class RenameAction extends MehanickoPrebacivanjeAction {
	
	public RenameAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, loadIcon("ikonice/rename.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/rename.png", 24, 24));
		putValue(NAME, "Rename");
		putValue(SHORT_DESCRIPTION, "Rename an object.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getWorkspaceTree().startEditingAtPath(MainFrame.getInstance().getWorkspaceTree().getSelectionPath());
	}

}
