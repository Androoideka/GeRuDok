package model.workspace;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import gui.MainFrame;
import observer.IModelObserver;
import observer.IViewObserver;

public class Project implements MutableTreeNode, IModelObserver, Serializable {
	private String name;
	private Workspace ws;
	private List<Document> docs = new ArrayList<>();
	private transient List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	private File projectFile=null;
	private transient boolean changed=false;
	
	public Project(Workspace ws, String name) {
		setParent(ws);
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
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Document) {
			docs.add(index, (Document)node);
		}
		notifyObservers(node);
	}

	@Override
	public void remove(int index) {
		docs.remove(index);
		notifyObservers(null);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Document) {
			Document d = (Document)node;
			docs.remove(d);
		}
		notifyObservers(null);
	}

	@Override
	public void removeFromParent() {
		int index = ws.getIndex(this);
		ws.remove(this);
		ws = null;
		notifyObservers(new AtomicInteger(index));
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Workspace) {
			ws = (Workspace)newParent;
		}
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
	
	public File getProjectFile() {
		return projectFile;
	}


	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}
	
	public boolean isChanged() {
		return changed;
	}


	public void setChanged(boolean changed) {
		if (this.changed!=changed){
		     this.changed=changed;
		     SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		}
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
