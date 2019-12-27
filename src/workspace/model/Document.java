package workspace.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.MutableTreeNode;

import document.model.Page;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class Document extends MPNode {
	
	private List<Page> pages = new ArrayList<>();
	
	public Document() {
		this.setName("document");
	}
	
	public List<Page> getPages() {
		return pages;
	}

	public int getNumberOfPages() {
		return pages.size();
	}
	
	public void addPage(Page p) {
		if(!pages.contains(p)) {
			pages.add(p);
			notifyObservers(new ObserverNotification(p, ObserverEventType.ADD));
		}
	}
	
	public void removePage(Page p) {
		if(pages.remove(p)) {
			notifyObservers(new ObserverNotification(p, ObserverEventType.REMOVE));
		}
	}
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		return;
	}

	@Override
	public void remove(MutableTreeNode node) {
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
