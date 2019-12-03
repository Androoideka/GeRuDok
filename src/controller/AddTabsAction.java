package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.MainFrame;
import gui.WorkspaceTabbedMenu;
import model.workspace.MPNode;
import model.workspace.Project;

public class AddTabsAction extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1 && e.getClickCount()==2) {
			MPNode mpNode=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
			if(mpNode instanceof Project && mpNode!=null) {
				WorkspaceTabbedMenu wtb=MainFrame.getInstance().getWorkspaceTabbedMenu(); 
				wtb.setProject((Project)mpNode);
			}
		}
	}
}
