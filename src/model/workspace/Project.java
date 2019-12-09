package model.workspace;

import java.util.ArrayList;

import javax.swing.tree.MutableTreeNode;

import observer.ObserverEventType;
import observer.ObserverNotification;

public class Project extends MPNode {
	
	public Project() {
		children = new ArrayList<MPNode>();
		this.setName("project");
	}
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Document) {
			Document d = (Document)node;
			d.setParent(this);
			children.add(index, d);
			notifyObservers(new ObserverNotification(d, ObserverEventType.ADD));
		}
	}
	
	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Document) {
			Document d = (Document)node;
			children.remove(d);
		}
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Workspace) {
			if(parent != null) {
				parent.removeFromParent();
			}
			parent = (Workspace)newParent;
		}
	}
}
