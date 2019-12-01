package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import observer.IModelObserver;
import observer.IViewObserver;

public class Workspace implements MutableTreeNode, IModelObserver {
	private String name = "Workspace";
	private List<Project> prj = new ArrayList<>();
	private List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	
	public Workspace() {
		super();
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return Collections.enumeration(prj);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return prj.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return prj.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return prj.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return prj.size() == 0;
	}
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Project) {
			prj.add((Project)node);
		}
		notifyObservers(node);
	}

	@Override
	public void remove(int index) {
		prj.remove(index);
		notifyObservers(null);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Project) {
			Project p = (Project)node;
			prj.remove(p);
		}
		notifyObservers(null);
	}

	@Override
	public void removeFromParent() {
		return;
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		return;
	}

	@Override
	public void setUserObject(Object object) {
		return;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers(null);
	}

	@Override
	public String toString() {
		return name;
	}
	
	public Project getCurrentProject() {
		TreePath path=getSelectionPath();
		for(int i=0; i<path.getPathCount(); i++){
			if(path.getPathComponent(i) instanceof Project){
				return (Project)path.getPathComponent(i);
			}
		}
		return null;
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
	}
}
