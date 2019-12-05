package gui.workspace;

import java.awt.event.MouseAdapter;

import javax.swing.JTree;

import javax.swing.SwingUtilities;

import controller.ActionManager;
import controller.workspace.WorkspaceTreeController;
import interfaces.IWorkspaceView;
import model.workspace.MPNode;

public class WorkspaceTree extends JTree implements IWorkspaceView {
	public WorkspaceTree(MPNode ws) {
		addTreeSelectionListener(new WorkspaceTreeController());
	    setCellEditor(new WorkspaceTreeEditor(this,new WorkspaceTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRenderer());
	    setEditable(true);
	    setInvokesStopCellEditing(true);
	    
		for(MouseAdapter a : ActionManager.getInstance().getMouseListeners()) {
			addMouseListener(a);
		}
	    
	    ws.addObserver(this);
	}

	@Override
	public void update(Object event) {
		if(event instanceof MPNode) {
			MPNode obs = (MPNode)event;
			obs.addObserver(this);
		}
		this.expandRow(0);
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
