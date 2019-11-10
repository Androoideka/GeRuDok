package gui;

import javax.swing.JTabbedPane;

import observer.IModelObserver;
import observer.IViewObserver;

public class WorkspaceTabbedMenu extends JTabbedPane implements IViewObserver {
	public WorkspaceTabbedMenu() {
		super();
	}

	@Override
	public void update(Object event) {
		if(event instanceof IModelObserver) {
			IModelObserver obs = (IModelObserver)event;
			obs.addObserver(this);
		}
	}
}
