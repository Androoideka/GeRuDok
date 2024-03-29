package workspace.controller;

import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;
import workspace.model.MPNode;
import workspace.model.Repository;

public class SaveAction extends AbstractAction {
	public SaveAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("save.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("save.png"));
		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save changes.");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MPNode mpNode=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(mpNode != null) {
			Repository repository = Repository.getInstance();
			repository.save(mpNode);
		}
	}
}
