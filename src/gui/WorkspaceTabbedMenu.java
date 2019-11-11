package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.workspace.Document;
import model.workspace.Project;
import observer.IModelObserver;
import observer.IViewObserver;

public class WorkspaceTabbedMenu extends JTabbedPane implements IViewObserver {
	private Project prj;
	
	public WorkspaceTabbedMenu() {
		super();
		setTabLayoutPolicy(SCROLL_TAB_LAYOUT);
	}
	
	public Project getProject() {
		return prj;
	}
	
	public void setProject(Project prj) {
		this.prj=prj;
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
		}
		removeAll();
		if(prj!=null) {
			int br=prj.getChildCount();
			for(int i=0;i<br;i++) {
				Document d = (Document)prj.getChildAt(i);
				d.addObserver(this);
				this.addTab(d.toString(), new JPanel());
			}
		}
	}
}
