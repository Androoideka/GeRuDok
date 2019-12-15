package model.document;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import model.workspace.ModelElement;
import observer.ObserverEventType;
import observer.ObserverNotification;
import state.StateManager;

public class Page extends ModelElement {
	
	private List<Slot> slots = new ArrayList<>();
	
	//private StateManager stateManager = new StateManager(this);
	
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
	
	public Slot findSlotAtPosition(Point2D position) {
		//Returns last one at that location not first one
		Slot s = null;
		for(Slot slot : slots) {
			if(slot.getSlotPainter().isWithinSlot(position)) {
				s = slot;
			}
		}
		return s;
	}
	
	/*public void setRectangleState() {
		stateManager.setRectangleState();
	}
	
	public void setSelectState() {
		stateManager.setSelectState();
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}*/
}
