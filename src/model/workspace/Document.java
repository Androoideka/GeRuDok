package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observer.IModelObserver;
import observer.IViewObserver;

public class Document implements MutableTreeNode, IModelObserver {
	private String name;
	private Project prj;
	private List<Page> pages=new ArrayList<Page>();
	private List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	
	public Document(Project prj, String name) {
		this.prj = prj;
		this.name = name;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return Collections.enumeration(pages);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return pages.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return pages.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return pages.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return prj;
	}

	@Override
	public boolean isLeaf() {
		return(pages.size()==0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Page) {
			pages.add(index, (Page)node);
		}
		notifyObservers(node);
	}

	@Override
	public void remove(int index) {
		pages.remove(index);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Page) {
			pages.remove((Page)node);
		}
		notifyObservers(node);
	}

	@Override
	public void removeFromParent() {
		prj.remove(this);
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Project) {
			prj = (Project)newParent;
		}
	}

	@Override
	public void setUserObject(Object object) {
		// TODO Auto-generated method stub
		
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
		if(event==null || viewObservers.isEmpty()) {
			return;
		}
		for(IViewObserver viewObserver : viewObservers) {
			viewObserver.update(event);
		}
	}
}
