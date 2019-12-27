package document.view;

import javax.swing.JPanel;

import document.model.Page;
import document.model.Slot;
import observer.IViewObserver;
import observer.ObserverEventType;
import observer.ObserverNotification;

public abstract class PageView extends JPanel implements IViewObserver {
	protected Page page;

	public PageView(Page page) {
		super();
		
		setPage(page);
	}
	
	public Page getPage() {
		return page;
	}
	
	private void removePage() {
		if(page != null) {
			page.removeObserver(this);
			page = null;
		}
	}
	
	public void setPage(Page page) {
		if(this.page == page) {
			return;
		}
		
		removePage();
		
		this.page = page;
		if(page != null) {
			page.addObserver(this);
			for(Slot slot : page.getSlots()) {
				slot.addObserver(this);
			}
			setName(page.getName());
		}
	}
	
	@Override
	public void update(ObserverNotification event) {
		if(event.getEventType() == ObserverEventType.ADD) {
			event.getModelObserver().addObserver(this);
		}
		repaint();
	}
}
