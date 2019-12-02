package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.Document;
import model.workspace.Project;

public class NewDocumentAction extends AbstractAction {
	
	public NewDocumentAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.loadSmallIcon("ikonice/documentnew.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.loadBigIcon("ikonice/documentnew.png"));
		putValue(NAME, "New document");
		putValue(SHORT_DESCRIPTION, "Create a new document.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object p=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p  instanceof Project) {
			Project prj=(Project)MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
			Document d=new Document(prj);
			prj.insert(d, prj.getChildCount());
		}
	}

}
