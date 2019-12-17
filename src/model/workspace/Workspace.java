package model.workspace;

import java.util.ArrayList;

import javax.swing.tree.MutableTreeNode;

import observer.ObserverEventType;
import observer.ObserverNotification;

public class Workspace extends MPNode {	
	public Workspace() {
		children = new ArrayList<MPNode>();
		this.setName("Workspace");
	}
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Project) {
			Project p = (Project)node;
			p.setParent(this);
			children.add(p);
			notifyObservers(new ObserverNotification(p, ObserverEventType.ADD));
		}
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Project) {
			Project p = (Project)node;
			children.remove(p);
		}
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		return;
	}
}
