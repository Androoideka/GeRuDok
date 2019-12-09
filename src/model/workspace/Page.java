package model.workspace;

import javax.swing.tree.MutableTreeNode;

public class Page extends MPNode {
	
	public Page() {
		this.setName("page");
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
			if(parent != null) {
				parent.removeFromParent();
			}
			parent=(Document)newParent;
		}
	}
}
