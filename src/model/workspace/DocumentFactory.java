package model.workspace;

public class DocumentFactory extends MPNodeFactory {

	@Override
	public MPNode createNode() {
		Document d = new Document(null);
		return d;
	}

}
