package model.workspace;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observer.IModelObserver;
import observer.IViewObserver;

public class Page implements MutableTreeNode, IModelObserver {
	private String name;
	private Document doc;
	private List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	
	public Page(Document doc, String name) {
		this.doc=doc;
		this.name=name;
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
		doc.remove(this);
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Document) {
			doc = (Document)newParent;
		}
	}

	@Override
	public void setUserObject(Object object) {
		return;
	}
	
	@Override
	public void addObserver(IViewObserver viewObserver) {
		if(viewObserver==null) {
			return;
		}
		if(this.viewObservers.contains(viewObserver)) {
			return;
		}
		this.viewObservers.add(viewObserver);
	}

	@Override
	public void removeObserver(IViewObserver viewObserver) {
		if(viewObserver==null || !viewObservers.contains(viewObserver)) {
			return;
		}
		viewObservers.remove(viewObserver);
	}

	@Override
	public void notifyObservers(Object event) {
		if(viewObservers.isEmpty()) {
			return;
		}
		for(IViewObserver viewObserver : viewObservers) {
			viewObserver.update(event);
		}
	}
}
