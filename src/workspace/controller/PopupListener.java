package workspace.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.MainFrame;

public class PopupListener extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			MainFrame.getInstance().getWorkspaceTree().showMenuAtLocation(e.getX(), e.getY());
        }
	}
}
