package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

import observer.IModelObserver;
import observer.IViewObserver;

public class Project implements TreeNode, IModelObserver {
	private String name;
	private Workspace ws;
	private List<Document> docs = new ArrayList<>();
	private List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	
	public Project(Workspace ws, String name) {
		this.ws = ws;
		this.name = name;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return Collections.enumeration(docs);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return docs.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return docs.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return docs.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return ws;
	}

	@Override
	public boolean isLeaf() {
		return docs.size() == 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addDocument(Document doc) {
		docs.add(doc);
	}
	
	public void removeDocument(Document doc) {
		docs.remove(doc);
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
		if(event==null || viewObservers.isEmpty()) {
			return;
		}
		for(IViewObserver viewObserver : viewObservers) {
			viewObserver.update(event);
		}
	}
}
