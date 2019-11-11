package workspace.tree;

import javax.swing.JTree;

import javax.swing.SwingUtilities;

import controller.ActionManager;
import controller.workspace.WorkspaceTreeController;
import observer.IModelObserver;
import observer.IViewObserver;

public class WorkspaceTree extends JTree implements IViewObserver {
	public WorkspaceTree(IModelObserver ws) {
		addTreeSelectionListener(new WorkspaceTreeController());
	    setCellEditor(new WorkspaceTreeEditor(this,new WorkspaceTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRenderer());
	    setEditable(true);
	    setInvokesStopCellEditing(true);
	    
	    addMouseListener(ActionManager.getInstance().getPopupListener());
	    addMouseListener(ActionManager.getInstance().getAddTabsAction());
	    
	    ws.addObserver(this);
	}

	@Override
	public void update(Object event) {
		if(event instanceof IModelObserver) {
			IModelObserver obs = (IModelObserver)event;
			obs.addObserver(this);
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
}
