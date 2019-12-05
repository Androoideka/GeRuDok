package model.workspace;

import java.util.ArrayList;

import javax.swing.tree.MutableTreeNode;

public class Document extends MPNode {
	
	public Document(Project prj) {
		children = new ArrayList<MPNode>();
		setParent(prj);
		this.name = "document";
	}

	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Page) {
			Page p = (Page)node;
			p.setParent(this);
            children.add(index, p);
		}
		notifyObservers(node);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Page) {
			Page p = (Page)node;
			children.remove(p);
		}
		notifyObservers(null);
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Project) {
			parent = (Project)newParent;
		}
	}

	@Override
	public void addChild() {
		this.insert(new Page(this), this.getChildCount());
	}
}
