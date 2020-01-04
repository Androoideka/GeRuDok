package workspace.model;

import javax.swing.tree.MutableTreeNode;

import observer.ObserverEventType;
import observer.ObserverNotification;

public class Document extends MPNode {
	
	private DocumentContents contents = new DocumentContents();
	
	public Document() {
		this.setName("document");
	}
	
	public DocumentContents getContents() {
		return contents;
	}
	
	public void link(Document d) {
		this.contents = d.contents;
		notifyObservers(new ObserverNotification(contents, ObserverEventType.RENAME));
	}
	
	public void unlink() {
		contents = new DocumentContents(contents);
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
