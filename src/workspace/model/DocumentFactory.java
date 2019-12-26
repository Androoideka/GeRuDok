package workspace.model;

public class DocumentFactory extends MPNodeFactory {

	@Override
	public MPNode createNode() {
		Document d = new Document();
		return d;
	}
}
