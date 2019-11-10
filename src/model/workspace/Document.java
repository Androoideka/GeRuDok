package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

import observer.IModelObserver;
import observer.IViewObserver;

public class Document implements TreeNode, IModelObserver {
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
	
	public void addPage(Page p) {
		pages.add(p);
	}
	
	public void removePage(Page p) {
		pages.remove(p);
	}
	
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
		if(event==null || viewObservers.isEmpty()) {
			return;
		}
		for(IViewObserver viewObserver : viewObservers) {
			viewObserver.update(event);
		}
	}
}
