package model.workspace;

import java.util.ArrayList;

import javax.swing.tree.MutableTreeNode;

import observer.ObserverEventType;
import observer.ObserverNotification;

public class Document extends MPNode {
	
	public Document() {
		children = new ArrayList<MPNode>();
		this.setName("document");
	}

	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Page) {
			Page p = (Page)node;
			p.setParent(this);
            children.add(index, p);
            notifyObservers(new ObserverNotification(p, ObserverEventType.ADD));
		}
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Page) {
			Page p = (Page)node;
			children.remove(p);
		}
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Project) {
			if(parent != null) {
				parent.removeFromParent();
			}
			parent = (Project)newParent;
		}
	}
}
