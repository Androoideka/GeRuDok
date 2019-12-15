package model.document;

import java.util.ArrayList;
import java.util.List;

import model.workspace.ModelElement;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class Page extends ModelElement {
	
	private List<Slot> slots = new ArrayList<>();
	
	public Page() {
		this.setName("page");
	}
	
	public List<Slot> getSlots() {
		return slots;
	}

	public int getNumberOfSlots() {
		return slots.size();
	}
	
	public void addSlot(Slot s) {
		slots.add(s);
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.ADD));
	}
	
	public void removeSlot(Slot s) {
		slots.remove(s);
		this.notifyObservers(new ObserverNotification(this, ObserverEventType.REMOVE));
	}

	/*@Override
	public void insert(MutableTreeNode arg0, int arg1) {
		return;
	}

	@Override
	public void remove(MutableTreeNode node) {
		return;
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Document) {
			if(parent != null) {
				parent.removeFromParent();
			}
			parent=(Document)newParent;
		}
	}*/
}
