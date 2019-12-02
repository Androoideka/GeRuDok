package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.Document;
import model.workspace.Page;
import model.workspace.Project;
import model.workspace.Workspace;

public class NewAction extends AbstractAction {

	public NewAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.loadSmallIcon("ikonice/documentnew.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.loadBigIcon("ikonice/documentnew.png"));
		putValue(NAME, "New");
		putValue(SHORT_DESCRIPTION, "Create a new document.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object node = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (node instanceof Workspace || node == null) {
			Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceModel().getRoot();
			Project p=new Project(ws, "project");
			ws.insert(p, ws.getChildCount());
		}
		if (node instanceof Project) {
			Project prj=(Project)MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
			Document d=new Document(prj, "document");
			prj.insert(d, prj.getChildCount());
		}
		if (node instanceof Document) {
			Document d = (Document)MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
			Page p = new Page(d, "document");
			d.insert(p, d.getChildCount());
		}
	}
}
