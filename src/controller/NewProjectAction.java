package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.Project;
import model.workspace.Workspace;

public class NewProjectAction extends AbstractAction {	
	public NewProjectAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.loadSmallIcon("ikonice/projectnew.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.loadBigIcon("ikonice/projectnew.png"));
		putValue(NAME, "New project");
		putValue(SHORT_DESCRIPTION, "Create a new project.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object w=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (w  instanceof Workspace || w==null) {
			Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceTree().getRoot();
			Project p=new Project(ws);
			ws.insert(p, ws.getChildCount());
		}
	}
}
