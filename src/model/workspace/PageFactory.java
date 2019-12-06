package model.workspace;

public class PageFactory extends MPNodeFactory {

	@Override
	public MPNode createNode() {
		Page p = new Page(null);
		return p;
	}

}
