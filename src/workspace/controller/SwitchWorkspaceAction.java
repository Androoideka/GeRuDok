package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import controller.OpenRepository;
import helpers.ImageResizer;

public class SwitchWorkspaceAction extends AbstractAction {
	public SwitchWorkspaceAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/workspaceopen.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/workspaceopen.png"));
		putValue(NAME, "Switch workspace");
		putValue(SHORT_DESCRIPTION, "Switch current workspace.");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		OpenRepository or=new OpenRepository();
		or.switchWorkspace();
	}
	
}
