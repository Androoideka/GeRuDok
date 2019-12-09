package model.workspace;

public class ProjectFactory extends MPNodeFactory {

	@Override
	public MPNode createNode() {
		Project p = new Project();
		return p;
	}

}
