package model.workspace;

import java.util.ArrayList;

import javax.swing.tree.MutableTreeNode;

public class Project extends MPNode {
	
	public Project(Workspace ws) {
		children = new ArrayList<MPNode>();
		setParent(ws);
		this.name = "project";
	}
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Document) {
			Document d = (Document)node;
			d.setParent(this);
			children.add(index, d);
		}
		notifyObservers(node);
	}
	
	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Document) {
			Document d = (Document)node;
			children.remove(d);
		}
		notifyObservers(null);
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Workspace) {
			parent = (Workspace)newParent;
		}
	}
	
	@Override
	public void addChild() {
		this.insert(new Document(this), this.getChildCount());
	}
}
