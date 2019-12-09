package observer;

import model.workspace.MPNode;

public class ObserverNotification {

	private MPNode node;
	private ObserverEventType eventType;
	
	public ObserverNotification(MPNode node, ObserverEventType type) {
		this.node = node;
		this.eventType = type;
	}

	public MPNode getNode() {
		return node;
	}

	public ObserverEventType getEventType() {
		return eventType;
	}
}
