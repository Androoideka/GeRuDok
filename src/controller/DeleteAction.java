package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Collections;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import model.workspace.Document;
import model.workspace.Project;
import model.workspace.Workspace;

public class DeleteAction extends MehanickoPrebacivanjeAction {
	
	public DeleteAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, loadIcon("ikonice/delete.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/delete.png", 24, 24));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete an object.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object node=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (node instanceof Project) {
			Project p = (Project)node;
			((Workspace)p.getParent()).removeProject(p);
		}
		else if(node instanceof Document) {
			Document d = (Document)node;
			((Project)d.getParent()).removeDocument(d);
		}
	}

}
