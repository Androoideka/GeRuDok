package model.workspace;

public abstract class MPNodeFactory {
	public MPNode deliverNode() {
		MPNode node = createNode();
		return node;
	}
	
	public abstract MPNode createNode();
	
	public static MPNodeFactory GenerateNodeFactory(MPNode parent) {
		if(parent instanceof Workspace) return new ProjectFactory();
		else if(parent instanceof Project) return new DocumentFactory();
		else if(parent instanceof Document) return new PageFactory();
		return null;
	}
}
