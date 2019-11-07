package model.workspace;

import javax.swing.tree.DefaultTreeModel;

public class WSModel extends DefaultTreeModel {
	public WSModel(Workspace workspace) {
		super(workspace);
	}
	
	public void addProject(Project project){
		((Workspace)getRoot()).addProject(project);
	}
}
