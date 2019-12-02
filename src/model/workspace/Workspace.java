package model.workspace;

import java.util.ArrayList;

import javax.swing.tree.MutableTreeNode;

public class Workspace extends MPNode {
	
	public Workspace() {
		children = new ArrayList<MPNode>();
		this.name = "Workspace";
	}

	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Project) {
			children.add((Project)node);
		}
		notifyObservers(node);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Project) {
			Project p = (Project)node;
			children.remove(p);
		}
		notifyObservers(null);
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		return;
	}
	
	@Override
	public void addChild() {
		this.insert(new Project(this), this.getChildCount());
	}
}
