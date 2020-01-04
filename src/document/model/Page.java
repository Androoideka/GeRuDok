package document.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import model.ModelElement;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class Page extends ModelElement {
	
	private List<Slot> slots = new ArrayList<>();
	
	public Page() {
		this.setName("page");
	}
	
	public Page(Page p) {
		for(Slot slot : p.slots) {
			this.slots.add(slot.clone());
		}
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
	
	public Slot findSlotAtPosition(Point2D position) {
		//Returns last one at that location not first one
		Slot s = null;
		for(Slot slot : slots) {
			if(slot.getSlotPainter().isWithinSlot(position) || slot.getHandleForPoint(position) != null) {
				s = slot;
			}
		}
		return s;
	}
}
