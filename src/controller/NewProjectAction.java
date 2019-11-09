package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import gui.MainFrame;
import model.workspace.Project;
import model.workspace.Workspace;

public class NewProjectAction extends MehanickoPrebacivanjeAction {
	public NewProjectAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/projectnew.png", 24, 24));
		putValue(NAME, "New project");
		putValue(SHORT_DESCRIPTION, "Create a new project.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object w=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (w  instanceof Workspace) {
			Project p=new Project((Workspace)w, "project");
			((Workspace)w).addProject(p);
		}
	}
}
