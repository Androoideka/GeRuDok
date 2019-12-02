package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class Document extends MPNode {
	
	public Document(Project prj) {
		children = new ArrayList<MPNode>();
		setParent(prj);
		this.name = "document";
	}

	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Page) {
            children.add(index, (Page)node);
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
