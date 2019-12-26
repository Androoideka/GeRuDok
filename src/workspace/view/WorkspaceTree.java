package workspace.view;

import java.awt.Rectangle;

import java.awt.event.MouseAdapter;

import javax.swing.JTree;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import controller.ActionManager;
import observer.IViewObserver;
import observer.ObserverEventType;
import observer.ObserverNotification;
import workspace.controller.WorkspaceTreeController;
import workspace.model.MPNode;
import workspace.model.Workspace;
import workspace.model.WorkspaceModel;

public class WorkspaceTree extends JTree implements IViewObserver {
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
	}

	public void update(ObserverNotification event) {
		if(event.getEventType() == ObserverEventType.ADD) {
			event.getModelObserver().addObserver(this);
		}
		this.expandRow(0);
		SwingUtilities.updateComponentTreeUI(this);
	}

	public MPNode getSelectedNode() {
		return (MPNode)this.getLastSelectedPathComponent();
	}
	
	public void resetSelectedNode() {
		this.setSelectionPath(null);
	}

	public MPNode getRoot() {
		return (MPNode)this.getModel().getRoot();
	}
	
	public void setRoot(Workspace ws) {
		this.setModel(new WorkspaceModel(ws));
		ws.addObserver(this);
		for(int i = 0; i < ws.getChildCount(); i++) {
			MPNode child = (MPNode) ws.getChildAt(i);
			ws.insert(child, i);
		}
	}

	public void startEditing() {
		if(this.getSelectionPath() != null) {
			this.startEditingAtPath(this.getSelectionPath());
		}
	}
	
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
