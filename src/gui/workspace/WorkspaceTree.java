package gui.workspace;

import java.awt.event.MouseAdapter;

import javax.swing.AbstractAction;
import javax.swing.JTree;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import controller.ActionManager;
import controller.workspace.WorkspaceTreeController;
import interfaces.Tree;
import model.workspace.MPNode;
import observer.IModelObserver;
import observer.IViewObserver;

public class WorkspaceTree extends JTree implements IViewObserver, Tree {
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
