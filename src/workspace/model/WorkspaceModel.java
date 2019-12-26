package workspace.model;

import javax.swing.tree.DefaultTreeModel;

public class WorkspaceModel extends DefaultTreeModel {
	public WorkspaceModel(Workspace workspace) {
		super(workspace);
	}
}
