package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JTabbedPane;

import model.workspace.Document;
import model.workspace.Project;
import observer.IViewObserver;

public class WorkspaceTabbedMenu extends JTabbedPane implements IViewObserver {
	private Project prj;
	private List<DocumentView> docView = new ArrayList<>();
	
	public WorkspaceTabbedMenu() {
		super();
		setTabLayoutPolicy(SCROLL_TAB_LAYOUT);
	}
	
	private void createDocViewForDocument(Document d) {
		DocumentView view = new DocumentView(d);
		d.addObserver(this);
		docView.add(view);
		this.add(view);
	}
	
	public Project getProject() {
		return prj;
	}
	
	public void setProject(Project prj) {
		if(this.prj == prj) {
			return;
		}
		removeAll();
		if(this.prj != null) {
			this.prj.removeObserver(this);
		}
		this.prj=prj;
		prj.addObserver(this);
		int br = prj.getChildCount();
		for(int i = 0; i < br; i++) {
			Document d = (Document)prj.getChildAt(i);
			createDocViewForDocument(d);
		}
	}

	@Override
	public void update(Object event) {
		if(prj.getParent() == null) {
			prj = null;
			removeAll();
		}
		else if(event instanceof Document) {
			Document d = (Document)event;
			createDocViewForDocument(d);
		}
		else if(prj!=null) {
			if(event == null) {
				for(int i = 0; i < this.getTabCount(); i++) {
					DocumentView view = (DocumentView)this.getComponentAt(i);
					this.setTitleAt(i, view.getName());
				}
			}
			else if(event instanceof AtomicInteger) {
				AtomicInteger i = (AtomicInteger)event;
				int index = this.indexOfComponent(docView.get(i.get()));
				if(index != -1) {
					this.removeTabAt(index);
				}
				docView.remove(i.get());
			}
		}
	}
}
