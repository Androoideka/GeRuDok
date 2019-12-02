package model.workspace;

import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class Page extends MPNode {
	private Document doc;
	
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
			doc = (Document)newParent;
		}
	}

	@Override
	public void addChild() {
		return;
	}
}
