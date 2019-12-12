package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.MainFrame;

public class PopupListener extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 3) {
			MainFrame.getInstance().getWorkspaceTree().showMenuAtLocation(e.getX(), e.getY());
        }
	}
}
