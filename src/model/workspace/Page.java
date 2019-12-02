package model.workspace;

import javax.swing.tree.MutableTreeNode;

public class Page extends MPNode {
	
	public Page(Document doc) {
		setParent(doc);
		this.name = "page";
	}

	@Override
	public void insert(MutableTreeNode arg0, int arg1) {
		return;
	}

	@Override
	public void remove(MutableTreeNode node) {
		return;
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Document) {
			parent=(Document)newParent;
		}
	}

	@Override
	public void addChild() {
		return;
	}
}
