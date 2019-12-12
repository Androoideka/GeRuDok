package gui.workspace;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;

import javax.swing.JTree;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import controller.ActionManager;
import controller.workspace.WorkspaceTreeController;
import interfaces.IWorkspaceView;
import model.workspace.MPNode;
import model.workspace.Workspace;
import model.workspace.WorkspaceModel;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class WorkspaceTree extends JTree implements IWorkspaceView {
	public WorkspaceTree() {
		addTreeSelectionListener(new WorkspaceTreeController());
	    setCellEditor(new WorkspaceTreeEditor(this,new WorkspaceTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRenderer());
	    setEditable(true);
	    setInvokesStopCellEditing(true);
	    
		for(MouseAdapter a : ActionManager.getInstance().getMouseListeners()) {
			addMouseListener(a);
		}
	    
		this.setRoot(new Workspace());
		this.getRoot().addObserver(this);
	}

	@Override
	public void update(ObserverNotification event) {
		if(event.getEventType() == ObserverEventType.ADD) {
			event.getNode().addObserver(this);
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
	public void setRoot(Workspace ws) {
		this.setModel(new WorkspaceModel(ws));
	}

	@Override
	public void startEditing() {
		if(this.getSelectionPath() != null) {
			this.startEditingAtPath(this.getSelectionPath());
		}
	}
	
	@Override
	public void showMenuAtLocation(int x, int y) {
        TreePath path = this.getPathForLocation(x, y);
        this.setSelectionPath(path);
        Rectangle pathBounds = this.getUI().getPathBounds(this, path);
        if (pathBounds != null && pathBounds.contains (x, y))
        {
            TreePopupMenu menu = new TreePopupMenu(this.getSelectedNode());
            menu.show (this, pathBounds.x, pathBounds.y + pathBounds.height);
        }
	}
}
