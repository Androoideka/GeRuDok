package document.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import model.ModelElement;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class PageSelectionModel extends ModelElement {
	private List<Slot> selectedSlots = new ArrayList<>();
	
	public PageSelectionModel() {
		this.setName("selection model");
	}
	
	public List<Slot> getSlots() {
		return selectedSlots;
	}

	public int getNumberOfSlots() {
		return selectedSlots.size();
	}
	
	public void addSlot(Slot s) {
		selectedSlots.add(s);
		this.notifyObservers(new ObserverNotification(s, ObserverEventType.ADD));
	}
	
	public void removeSlot(Slot s) {
		selectedSlots.remove(s);
		this.notifyObservers(new ObserverNotification(s, ObserverEventType.REMOVE));
	}
	
	public Slot findSlotAtPosition(Point2D position) {
		//Returns last one at that location not first one
		Slot s = null;
		for(Slot slot : selectedSlots) {
			if(slot.getSlotPainter().isWithinSlot(position)) {
				s = slot;
			}
		}
		return s;
	}
}
