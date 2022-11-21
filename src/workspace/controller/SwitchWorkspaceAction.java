package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import helpers.LoadContext;
import helpers.LoadPurpose;
import view.MainFrame;
import workspace.model.Repository;
import workspace.model.Workspace;

public class SwitchWorkspaceAction extends AbstractAction {
	public SwitchWorkspaceAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("workspaceopen.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("workspaceopen.png"));
		putValue(NAME, "Switch workspace");
		putValue(SHORT_DESCRIPTION, "Switch current workspace.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Repository repository = Repository.getInstance();
		LoadContext<Workspace> context = new LoadContext<>(Workspace.class, LoadPurpose.SWITCH);
		Workspace newWorkspace = repository.<Workspace>open(context);
		if (newWorkspace != null) {
			MainFrame.getInstance().getWorkspaceTree().setRoot(newWorkspace);
		}
	}

}
