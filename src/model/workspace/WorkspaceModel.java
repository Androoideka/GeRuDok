package model.workspace;

import javax.swing.tree.DefaultTreeModel;

public class WorkspaceModel extends DefaultTreeModel {
	public WorkspaceModel(Workspace workspace) {
		super(workspace);
	}
	
	/*public void addProject(Project project){
		((Workspace)getRoot()).addProject(project);
	}
	
	public void removeProject(Project project) {
		((Workspace)getRoot()).removeProject(project);
	}*/
}
