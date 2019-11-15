package controller;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.tree.TreePath;

import gui.MainFrame;
import gui.TreePopupMenu;

public class PopupListener extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 3)
        {
            TreePath path = MainFrame.getInstance().getWorkspaceTree().getPathForLocation(e.getX(), e.getY());
            MainFrame.getInstance().getWorkspaceTree().setSelectionPath(path);
            Rectangle pathBounds = MainFrame.getInstance().getWorkspaceTree().getUI().getPathBounds(MainFrame.getInstance().getWorkspaceTree(), path);
            if (pathBounds != null && pathBounds.contains (e.getX(), e.getY()))
            {
                TreePopupMenu menu = new TreePopupMenu(path.getLastPathComponent());
                menu.show (MainFrame.getInstance().getWorkspaceTree(), pathBounds.x, pathBounds.y + pathBounds.height);
            }
        }
	}
}
