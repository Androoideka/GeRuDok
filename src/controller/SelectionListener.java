package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.MainFrame;
import gui.WorkspaceTabbedMenu;
import model.workspace.MPNode;

public class SelectionListener extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1 && e.getClickCount()==2) {
			MPNode node=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
			WorkspaceTabbedMenu wtb=MainFrame.getInstance().getWorkspaceTabbedMenu();
			wtb.openSelected(node);
		}
	}
}
