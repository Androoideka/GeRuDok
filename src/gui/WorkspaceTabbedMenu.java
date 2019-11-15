package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.workspace.Document;
import model.workspace.Project;
import observer.IModelObserver;
import observer.IViewObserver;

public class WorkspaceTabbedMenu extends JTabbedPane implements IViewObserver {
	private Project prj;
	private List<DocumentView> docView = new ArrayList<>();
	
	public WorkspaceTabbedMenu() {
		super();
		setTabLayoutPolicy(SCROLL_TAB_LAYOUT);
	}
	
	public Project getProject() {
		return prj;
	}
	
	public void setProject(Project prj) {
		this.prj=prj;
		int br = prj.getChildCount();
		for(int i = 0; i < br; i++) {
			Document d = (Document)prj.getChildAt(i);
			docView.add(new DocumentView(d));
		}
		update(prj);
	}

	@Override
	public void update(Object event) {
		if(event instanceof IModelObserver) {
			IModelObserver obs = (IModelObserver)event;
			obs.addObserver(this);
		}
		else if(prj.getParent() == null) {
			prj = null;
			removeAll();
		}
		if(prj!=null) {
			int br=docView.size();
			for(int i=0;i<br;i++) {
				if(event instanceof Integer && ((Integer)event).intValue() == i) {
					//docView.remove(i);
					if(i > br) {
						this.setSelectedIndex(i-1);
					}
					else {
					}
					this.removeTabAt(i);
				}
				else {
					this.addTab(docView.get(i).getDocument().getName(), docView.get(i));
				}
			}
		}
	}
}
