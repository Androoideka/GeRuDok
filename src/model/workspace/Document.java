package model.workspace;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.MutableTreeNode;

import model.document.Page;

public class Document extends MPNode {
	
	private List<Page> pages = new ArrayList<>();
	
	public Document() {
		//children = new ArrayList<MPNode>();
		this.setName("document");
	}
	
	public List<Page> getPages() {
		return pages;
	}

	public int getNumberOfPages() {
		return pages.size();
	}
	
	public void addPage(Page p) {
		pages.add(p);
	}
	
	public void removePage(Page p) {
		pages.remove(p);
	}

	@Override
	public void insert(MutableTreeNode node, int index) {
		/*if(node instanceof Page) {
			Page p = (Page)node;
			p.setParent(this);
            children.add(index, p);
            notifyObservers(new ObserverNotification(p, ObserverEventType.ADD));
		}*/
		return;
	}

	@Override
	public void remove(MutableTreeNode node) {
		/*if(node instanceof Page) {
			Page p = (Page)node;
			children.remove(p);
		}*/
		return;
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Project) {
			if(parent != null) {
				parent.removeFromParent();
			}
			parent = (Project)newParent;
		}
	}
}
