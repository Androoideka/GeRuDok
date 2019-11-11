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
	}
	
	public Project getProject() {
		return prj;
	}
	
	public void setProject(Project prj) {
		this.prj=prj;
		update(null);
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
			for(int i=1;i<br;i++) {
				this.addTab("Document "+i, new JPanel());
			}
		}
	}
}
