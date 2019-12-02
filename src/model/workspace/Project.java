package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class Project extends MPNode {
	
	public Project(Workspace ws) {
		children = new ArrayList<MPNode>();
		setParent(ws);
		this.name = "project";
	}
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Document) {
			children.add(index, (Document)node);
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
