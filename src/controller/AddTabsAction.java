package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.MainFrame;
import gui.WorkspaceTabbedMenu;
import model.workspace.Project;

public class AddTabsAction extends MouseAdapter {
	public void MousePressed(MouseEvent e) {
		if(e.getButton() == 3) {
			System.out.println("jesje");
			Object p=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
			if(p instanceof Project) {
				WorkspaceTabbedMenu wtb=MainFrame.getInstance().getWorkspaceTabbedMenu();
				Project prj=(Project)p; 
				wtb.setProject(prj);
			}
		}
	}
}
