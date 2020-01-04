package document.view;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

import observer.IViewObserver;
import observer.ObserverEventType;
import observer.ObserverNotification;
import workspace.model.Document;
import workspace.model.MPNode;
import workspace.model.Project;

public class WorkspaceTabbedMenu extends JTabbedPane implements IViewObserver {
	private Project prj;
	private List<DocumentView> docViews = new ArrayList<>();
	
	public WorkspaceTabbedMenu() {
		super();
		setTabLayoutPolicy(SCROLL_TAB_LAYOUT);
	}
	
	private void createViewForDocument(Document d) {
		if(prj == null) {
			return;
		}
		DocumentView view = new DocumentView(d);
		d.addObserver(this);
		docViews.add(view);
		this.add(view);
	}
	
	private DocumentView docViewWithDocument(Document d) {
		for(DocumentView docView : docViews) {
			if(docView.getDocument() == d) {
				return docView;
			}
		}
		return null;
	}
	
	public void openSelected(MPNode node) {
		if(node instanceof Project) {
			Project prj = (Project)node;
			if(this.prj == prj) {
				return;
			}
			if(this.prj != null) {
				removeAll();
				docViews.clear();
				this.prj.removeObserver(this);
			}
			
			this.prj=prj;
			prj.addObserver(this);
			
			int br = prj.getChildCount();
			for(int i = 0; i < br; i++) {
				Document d = (Document)prj.getChildAt(i);
				createViewForDocument(d);
			}
		}
		else if(node instanceof Document) {
			Document d = (Document)node;
			DocumentView docView = docViewWithDocument(d);
			if(docView != null && this.indexOfComponent(docView) == -1) {
				this.add(docView);
			}
		}
	}
	
	public void closeDocument() {
		int index = this.getSelectedIndex();
		if(index != -1) {
			this.removeTabAt(index);
		}
	}
	
	public DocumentView getCurrentView() {
		Component current = this.getSelectedComponent();
		
		if(current instanceof DocumentView) {
			return (DocumentView)current;
		}
		return null;
	}
	
	@Override
	public void update(ObserverNotification event) {
		if(event.getModelObserver() instanceof Project) {
			if(event.getEventType() == ObserverEventType.REMOVE) {
				removeAll();
				docViews.clear();
				prj = null;
			}
		}
		else if(event.getModelObserver() instanceof Document) {
			Document d = (Document)event.getModelObserver();
			if(event.getEventType() == ObserverEventType.ADD) {
				createViewForDocument(d);
			}
			DocumentView docView = docViewWithDocument(d);
			int index = this.indexOfComponent(docView);
			if(event.getEventType() == ObserverEventType.RENAME) {
				if(index != -1) {
					this.setTitleAt(index, d.toString());
				}
			}
			else if(event.getEventType() == ObserverEventType.REMOVE) {
				docViews.remove(docView);
				if(index != -1) {
					this.removeTabAt(index);
				}
			}
		}
	}
}
