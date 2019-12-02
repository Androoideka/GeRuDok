package workspace.tree;

import java.awt.Component;

import java.awt.Font;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import helpers.ImageResizer;
import model.workspace.Document;
import model.workspace.Project;
import model.workspace.Workspace;

public class WorkspaceTreeCellRenderer extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
		
		if (value instanceof Workspace ) {
			setIcon(ImageResizer.loadSmallIcon("ikonice/workspace.png"));
		}
		
		else if (value instanceof Project ) {
			setIcon(ImageResizer.loadSmallIcon("ikonice/project.png"));
		}
		
		else if (value instanceof Document ) {
			setIcon(ImageResizer.loadSmallIcon("ikonice/document.png"));
		}
		setFont(new Font(getFont().getFamily(), Font.BOLD, 14));
		return this;
	}
}
