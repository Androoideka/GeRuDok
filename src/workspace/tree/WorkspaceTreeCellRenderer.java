package workspace.tree;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.workspace.Document;
import model.workspace.Project;
import model.workspace.Workspace;

public class WorkspaceTreeCellRenderer extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
		
		if (value instanceof Workspace ) {
			URL imageURL = getClass().getResource("");
			Icon icon = null;
			if (imageURL != null) {
				icon = new ImageIcon(imageURL);
				}
			setIcon(icon);
		}
		
		else if (value instanceof Project ) {
			URL imageURL = getClass().getResource("");
			Icon icon = null;
			if (imageURL != null) {
				icon = new ImageIcon(imageURL);
				}
			setIcon(icon);
		}
		
		else if (value instanceof Document ) {
			URL imageURL = getClass().getResource("");
			Icon icon = null;
			if (imageURL != null) {
				icon = new ImageIcon(imageURL);
				}
			setIcon(icon);
		}
		return this;
	}
}
