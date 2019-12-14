package observer;

public class ObserverNotification {

	private IModelObserver modelObserver;
	private ObserverEventType eventType;
	
	public ObserverNotification(IModelObserver modelObserver, ObserverEventType type) {
		this.modelObserver = modelObserver;
		this.eventType = type;
	}

	public IModelObserver getModelObserver() {
		return modelObserver;
	}

	public ObserverEventType getEventType() {
		return eventType;
	}
}
