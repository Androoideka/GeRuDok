package workspace.tree;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import controller.ActionManager;
import controller.workspace.WorkspaceTreeController;

public class WorkspaceTree extends JTree {
	public WorkspaceTree() {
		addTreeSelectionListener(new WorkspaceTreeController());
	    setCellEditor(new WorkspaceTreeEditor(this,new WorkspaceTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRenderer());
	    setEditable(true);
	    
	    addMouseListener(ActionManager.getInstance().getPopupListener());
	}
}
