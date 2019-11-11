package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
		update(new Object());
		this.prj.addObserver(this);
	}

	@Override
	public void update(Object event) {
		if(event instanceof IModelObserver) {
			IModelObserver obs = (IModelObserver)event;
			obs.addObserver(this);
			
		}
		if(prj!=null) {
			int br=prj.getChildCount();
			removeAll();
			for(int i=0;i<br;i++) {
				this.addTab(prj.getChildAt(i).toString(), new JPanel());
			}
		}
	}
}
