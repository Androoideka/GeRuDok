package workspace.model;

import javax.swing.tree.DefaultTreeModel;

public class ProjectModel extends DefaultTreeModel {
	public ProjectModel(Project prj) {
		super(prj);
	}
}
