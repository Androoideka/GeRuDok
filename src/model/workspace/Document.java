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

public class Document extends MPNode {//implements MutableTreeNode, IModelObserver, Serializable {
	//private String name;
	private Project prj;
	private List<Page> pages=new ArrayList<Page>();
	//private transient List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	private String documentFile=null;
	
	public Document(Project prj) {
		setParent(prj);
		this.name = "document";
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
	
	public String getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(String projectFile) {
		this.documentFile = projectFile;
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
	public void addChild() {
		this.insert(new Page(this), this.getChildCount());
	}
}
