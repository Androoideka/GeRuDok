package model.workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observer.IModelObserver;
import observer.IViewObserver;

public class Page extends MPNode { //implements MutableTreeNode, IModelObserver, Serializable {
	private String name;
	private Document doc;
	private transient List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	
	public Page(Document doc) {
		setParent(doc);
		this.name = "page";
	}
	
	@Override
	public Enumeration<? extends TreeNode> children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		return -1;
	}

	@Override
	public TreeNode getParent() {
		return doc;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public void insert(MutableTreeNode arg0, int arg1) {
		return;
	}

	@Override
	public void remove(int index) {
		return;
	}

	@Override
	public void remove(MutableTreeNode node) {
		return;
	}

	@Override
	public void removeFromParent() {
		int index = doc.getIndex(this);
		doc.remove(this);
		doc = null;
		notifyObservers(new AtomicInteger(index));
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
