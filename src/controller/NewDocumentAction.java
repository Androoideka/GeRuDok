package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import gui.MainFrame;
import model.workspace.Document;
import model.workspace.Project;

public class NewDocumentAction extends MehanickoPrebacivanjeAction {
	
	public NewDocumentAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/documentnew.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/documentnew.png", 24, 24));
		putValue(NAME, "New document");
		putValue(SHORT_DESCRIPTION, "Create a new document.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object p=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p  instanceof Project) {
			Project prj=(Project)MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
			Document d=new Document(prj, "document");
			prj.insert(d, prj.getChildCount());
		}
	}

}
