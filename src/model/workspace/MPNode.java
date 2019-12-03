package model.workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observer.IModelObserver;
import observer.IViewObserver;

public abstract class MPNode implements MutableTreeNode, IModelObserver, Serializable {
	protected String name;
	protected MPNode parent;
	protected List<MPNode> children;
	private transient List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	private String file=null;
	private boolean changed=true;

	@Override
	public Enumeration<? extends TreeNode> children() {
		return Collections.enumeration(children);
	}

	@Override
	public boolean getAllowsChildren() {
		return children != null;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		if(children != null) {
			return children.get(childIndex);
		}
		return null;
	}

	@Override
	public int getChildCount() {
		if(children != null) {
			return children.size();
		}
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		if(children != null) {
			return children.indexOf(node);
		}
		return -1;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		if(children != null) {
			return children.size() == 0;
		}
		return true;
	}
	
	@Override
	public void remove(int index) {
		children.remove(index);
		notifyObservers(null);
	}

	@Override
	public void removeFromParent() {
		if(parent != null) {
			int index = parent.getIndex(this);
			parent.remove(this);
			parent = null;
			notifyObservers(new AtomicInteger(index));
		}
	}

	@Override
	public void setUserObject(Object object) {
		return;
	}
	
	public abstract void addChild();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers(null);
	}
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file=file;
		notifyObservers(null);
	}
	
	public boolean getChanged() {
		return changed;
	}
	
	public void setChanged(boolean changed) {
		this.changed=changed;
	}
	
	@Override
	public String toString() {
		return name;
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
		for(IViewObserver viewObserver : viewObservers) {
			viewObserver.update(event);
		}
		changed=true;
	}
}
