package workspace.tree;

import javax.swing.JTree;
import javax.swing.SwingUtilities;

import controller.ActionManager;
import controller.workspace.WorkspaceTreeController;
import observer.IViewObserver;

public class WorkspaceTree extends JTree implements IViewObserver {
	public WorkspaceTree() {
		addTreeSelectionListener(new WorkspaceTreeController());
	    setCellEditor(new WorkspaceTreeEditor(this,new WorkspaceTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRenderer());
	    setEditable(true);
	    setInvokesStopCellEditing(true);
	    
	    addMouseListener(ActionManager.getInstance().getPopupListener());
	}

	@Override
	public void update(Object event) {
		SwingUtilities.updateComponentTreeUI(this);
	}
}
