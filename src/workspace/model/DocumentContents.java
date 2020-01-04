package workspace.model;

import java.util.ArrayList;
import java.util.List;

import document.model.Page;
import model.ModelElement;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class DocumentContents extends ModelElement {
	
	private List<Page> pages = new ArrayList<>();
	
	public DocumentContents() {
		
	}
	
 	public DocumentContents(DocumentContents dc) {
		for(Page p : dc.pages) {
			this.pages.add(new Page(p));
		}
	}

	public List<Page> getPages() {
		return pages;
	}

	public int getNumberOfPages() {
		return pages.size();
	}
	
	public void addPage(Page p) {
		if(!pages.contains(p)) {
			pages.add(p);
			notifyObservers(new ObserverNotification(p, ObserverEventType.ADD));
		}
	}
	
	public void removePage(Page p) {
		if(pages.remove(p)) {
			notifyObservers(new ObserverNotification(p, ObserverEventType.REMOVE));
		}
	}
}
