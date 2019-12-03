package gui.workspace;

import java.awt.event.MouseAdapter;

import javax.swing.JTree;

import javax.swing.SwingUtilities;

import controller.ActionManager;
import controller.workspace.WorkspaceTreeController;
import interfaces.IWorkspaceView;
import model.workspace.MPNode;
import observer.IModelObserver;
import observer.IViewObserver;

public class WorkspaceTree extends JTree implements IViewObserver, IWorkspaceView {
	public WorkspaceTree(IModelObserver ws) {
		addTreeSelectionListener(new WorkspaceTreeController());
	    setCellEditor(new WorkspaceTreeEditor(this,new WorkspaceTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRenderer());
	    setEditable(true);
	    setInvokesStopCellEditing(true);
	    
		for(MouseAdapter a : ActionManager.getInstance().getMouseListeners()) {
			addMouseListener(a);
		}
	    //addMouseListener(ActionManager.getInstance().getPopupListener());
	    //addMouseListener(ActionManager.getInstance().getAddTabsAction());
	    
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

	@Override
	public MPNode getSelectedNode() {
		return (MPNode)this.getLastSelectedPathComponent();
	}
	
	@Override
	public void resetSelectedNode() {
		this.setSelectionPath(null);
	}


	@Override
	public MPNode getRoot() {
		return (MPNode)this.getModel().getRoot();
	}

	@Override
	public void startEditing() {
		if(this.getSelectionPath() != null) {
			this.startEditingAtPath(this.getSelectionPath());
		}
	}
}
