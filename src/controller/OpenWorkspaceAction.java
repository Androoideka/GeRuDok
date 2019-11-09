package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class OpenWorkspaceAction extends MehanickoPrebacivanjeAction {
	
	public OpenWorkspaceAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/workspaceopen.png", 24, 24));
		putValue(NAME, "Open workspace");
		putValue(SHORT_DESCRIPTION, "Open a new workspace.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
