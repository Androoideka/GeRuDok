package model.workspace;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.MutableTreeNode;

import model.document.Page;
import observer.ObserverEventType;
import observer.ObserverNotification;
import state.StateManager;

public class Document extends MPNode {
	
	private List<Page> pages = new ArrayList<>();
	
	private transient StateManager stateManager = new StateManager(this);
	
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
	
	public void setRectangleState() {
		stateManager.setRectangleState();
	}
	
	public void setCircleState() {
		stateManager.setCircleState();
	}
	
	public void setSelectState() {
		stateManager.setSelectState();
	}
	
	public StateManager getStateManager() {
		return stateManager;
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
