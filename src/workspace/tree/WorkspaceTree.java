package workspace.tree;

import javax.swing.JTree;
import javax.swing.SwingUtilities;

import controller.ActionManager;
import controller.workspace.WorkspaceTreeController;
import gui.MainFrame;
import model.workspace.Workspace;
import model.workspace.WorkspaceModel;
import observer.IViewObserver;

public class WorkspaceTree extends JTree implements IViewObserver {
	public WorkspaceTree() {
		addTreeSelectionListener(new WorkspaceTreeController());
	    setCellEditor(new WorkspaceTreeEditor(this,new WorkspaceTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRenderer());
	    setEditable(true);
	    setInvokesStopCellEditing(true);
	    
	    addMouseListener(ActionManager.getInstance().getPopupListener());
	    
	    Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceModel().getRoot();
	    ws.addObserver(this);
	}

	@Override
	public void update(Object event) {
		SwingUtilities.updateComponentTreeUI(this);
	}
}
