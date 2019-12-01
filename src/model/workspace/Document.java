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

public class Document implements MutableTreeNode, IModelObserver, Serializable {
	private String name;
	private Project prj;
	private List<Page> pages=new ArrayList<Page>();
	private transient List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	private File documentFile=null;
	private transient boolean changed=false;
	
	public Document(Project prj, String name) {
		setParent(prj);
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
		notifyObservers(null);
	}
	
	public String toString() {
		return name;
	}
	
	public File getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(File projectFile) {
		this.documentFile = projectFile;
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
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Page) {
			pages.add(index, (Page)node);
		}
		notifyObservers(node);
	}

	@Override
	public void remove(int index) {
		pages.remove(index);
		notifyObservers(null);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Page) {
			Page p = (Page)node;
			pages.remove(p);
		}
		notifyObservers(null);
	}

	@Override
	public void removeFromParent() {
		int index = prj.getIndex(this);
		prj.remove(this);
		prj = null;
		notifyObservers(new AtomicInteger(index));
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Project) {
			prj = (Project)newParent;
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
		for(IViewObserver viewObserver : viewObservers) {
			viewObserver.update(event);
		}
	}
}
