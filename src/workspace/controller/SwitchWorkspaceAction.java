package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;
import workspace.model.MPNode;
import workspace.model.Repository;
import workspace.model.Workspace;

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
		Repository repository = Repository.getInstance();
		MPNode mpNode = repository.open();
		if(mpNode instanceof Workspace) {
			MainFrame.getInstance().getWorkspaceTree().setRoot((Workspace)mpNode);
		}
	}
	
}
