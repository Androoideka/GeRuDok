package workspace.view;

import workspace.model.MPNode;
import workspace.model.Project;
import workspace.model.ProjectModel;

public class BackupTree extends WorkspaceTree {
	public BackupTree() {
		super();
	}
	
	public void setRoot(Project prj) {
		this.setModel(new ProjectModel(prj));
		prj.addObserver(this);
		for(int i = 0; i < prj.getChildCount(); i++) {
			MPNode child = (MPNode) prj.getChildAt(i);
			prj.insert(child, i);
		}
	}
}
