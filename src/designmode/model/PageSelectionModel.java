package designmode.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import document.model.Slot;
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
		s.setSelected(true);
		this.notifyObservers(new ObserverNotification(s, ObserverEventType.ADD));
	}
	
	public void removeSlot(Slot s) {
		selectedSlots.remove(s);
		s.setSelected(false);
		this.notifyObservers(new ObserverNotification(s, ObserverEventType.REMOVE));
	}
	
	public void removeAll() {
		for(Slot slot : selectedSlots) {
			slot.setSelected(false);
		}
		selectedSlots.clear();
	}
	
	public Handle getHandleForPoint(Point2D position) {
		for(Slot slot : selectedSlots) {
			Handle handle = slot.getHandleForPoint(position);
			if(handle != null) {
				return handle;
			}
		}
		return null;
	}
	
	public Slot findSlotAtPosition(Point2D position) {
		//Returns last one at that location not first one
		Slot s = null;
		for(Slot slot : selectedSlots) {
			if(slot.getSlotPainter().isWithinSlot(position) || slot.getHandleForPoint(position) != null) {
				s = slot;
			}
		}
		return s;
	}
}
