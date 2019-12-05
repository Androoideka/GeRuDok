package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JTabbedPane;

import model.workspace.Document;
import model.workspace.MPNode;
import model.workspace.Project;
import observer.IViewObserver;

public class WorkspaceTabbedMenu extends JTabbedPane implements IViewObserver {
	private Project prj;
	private List<DocumentView> docViews = new ArrayList<>();
	
	public WorkspaceTabbedMenu() {
		super();
		setTabLayoutPolicy(SCROLL_TAB_LAYOUT);
	}
	
	private void createDocViewForDocument(Document d) {
		if(prj == null) {
			return;
		}
		DocumentView view = new DocumentView(d);
		d.addObserver(this);
		docViews.add(view);
		this.add(view);
	}
	
	private void removeDocuments() {
		removeAll();
		for(DocumentView docView : docViews) {
			docView.getDocument().removeObserver(this);
		}
		docViews.clear();
	}
	
	private DocumentView docViewWithDocument(Document d) {
		for(DocumentView docView : docViews) {
			if(docView.getDocument() == d) {
				return docView;
			}
		}
		return null;
	}
	
	public Project getProject() {
		return prj;
	}
	
	public void openSelected(MPNode node) {
		if(node instanceof Project) {
			Project prj = (Project)node;
			if(this.prj == prj) {
				return;
			}
			if(this.prj != null) {
				this.prj.removeObserver(this);
			}
			this.prj=prj;
			prj.addObserver(this);
			
			removeDocuments();
			int br = prj.getChildCount();
			for(int i = 0; i < br; i++) {
				Document d = (Document)prj.getChildAt(i);
				createDocViewForDocument(d);
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
	
	@Override
	public void update(Object event) {
		if(prj.getParent() == null) {
			prj = null;
			removeDocuments();
		}
		else if(event instanceof Document) {
			Document d = (Document)event;
			createDocViewForDocument(d);
		}
		else if(event instanceof AtomicInteger) {
			AtomicInteger i = (AtomicInteger)event;
			DocumentView docView = docViews.get(i.get());
			int index = this.indexOfComponent(docView);
			if(index != -1) {
				this.removeTabAt(index);
			}
			docViews.remove(docView);
		}
		else if(event == null) {
			for(int i = 0; i < this.getTabCount(); i++) {
				DocumentView docView = (DocumentView)this.getComponentAt(i);
				this.setTitleAt(i, docView.getName());
			}
		}
	}
}
