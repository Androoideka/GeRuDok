package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import helpers.LoadContext;
import helpers.LoadPurpose;
import view.MainFrame;
import workspace.model.MPNode;
import workspace.model.Project;
import workspace.model.Repository;

public class OpenAction extends AbstractAction {
	public OpenAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("projectopen.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("projectopen.png"));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open an existing project.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Repository repository = Repository.getInstance();
		LoadContext<Project> context = new LoadContext<>(Project.class, LoadPurpose.ADD);
		Project project = repository.open(context);
		if (project != null) {
			MPNode mpParent = MainFrame.getInstance().getWorkspaceTree().getRoot();
			mpParent.insert(project, mpParent.getChildCount());
		}
	}
}
