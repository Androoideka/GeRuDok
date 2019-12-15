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
		this.notifyObservers(new ObserverNotification(s, ObserverEventType.ADD));
	}
	
	public void removeSlot(Slot s) {
		slots.remove(s);
		this.notifyObservers(new ObserverNotification(s, ObserverEventType.REMOVE));
	}
}
