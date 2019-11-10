package observer;

public interface IModelObserver {
	void addObserver(IViewObserver viewObserver);
	void removeObserver(IViewObserver viewObserver);
	void notifyObservers(Object event);
}
