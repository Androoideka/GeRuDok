package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;
import workspace.model.MPNode;
import workspace.model.Repository;

public class SaveAsAction extends AbstractAction {
	public SaveAsAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("save.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("save.png"));
		putValue(NAME, "Save as");
		putValue(SHORT_DESCRIPTION, "Save changes in a new folder.");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MPNode mpNode=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(mpNode != null) {
			Repository repository = Repository.getInstance();
			repository.saveAs(mpNode);
		}
	}
}
