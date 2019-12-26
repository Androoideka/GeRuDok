package document.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import document.view.WorkspaceTabbedMenu;
import view.MainFrame;
import workspace.model.MPNode;

public class SelectionListener extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount()==2) {
			MPNode node=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
			WorkspaceTabbedMenu wtb=MainFrame.getInstance().getWorkspaceTabbedMenu();
			wtb.openSelected(node);
		}
	}
}
