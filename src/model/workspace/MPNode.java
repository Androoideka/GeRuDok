package model.workspace;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observer.IViewObserver;
import observer.ObserverEventType;
import observer.ObserverNotification;

public abstract class MPNode extends ModelElement implements MutableTreeNode {
	
	protected List<MPNode> children;
	private String file=null;
	
	protected transient MPNode parent;
	private transient boolean changed=true;

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
	}

	@Override
	public void removeFromParent() {
		if(parent != null) {
			parent.remove(this);
			parent = null;
			notifyObservers(new ObserverNotification(this, ObserverEventType.REMOVE));
			clearObservers();
		}
	}

	@Override
	public void setUserObject(Object object) {
		return;
	}
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file=file;
	}
	
	public boolean isChanged() {
		return changed;
	}
	
	public void setChanged(boolean changed) {
		this.changed=changed;
	}
	
	@Override
	public void removeObserver(IViewObserver viewObserver) {
		super.removeObserver(viewObserver);
		if(children != null) {
			for(MPNode node : children) {
				node.removeObserver(viewObserver);
			}
		}
	}
	
	@Override
	public void notifyObservers(ObserverNotification event) {
		super.notifyObservers(event);
		changed=true;
	}
	
	@Override
	protected void clearObservers() {
		super.clearObservers();
		if(children != null) {
			for(MPNode node : children) {
				node.clearObservers();
			}
		}
	}
}
