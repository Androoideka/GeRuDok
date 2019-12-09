package controller;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.tree.TreePath;

import gui.MainFrame;
import gui.workspace.TreePopupMenu;

public class PopupListener extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 3) {
			MainFrame.getInstance().getWorkspaceTree().showMenuAtLocation(e.getX(), e.getY());
        }
	}
}
