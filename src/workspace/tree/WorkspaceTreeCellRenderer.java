package workspace.tree;

import java.awt.Component;
import java.awt.Font;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
			setIcon(ImageResizer.getProperlyScaledImage("ikonice/workspaceopen.png", 16, 16));
		}
		
		else if (value instanceof Project ) {
			setIcon(ImageResizer.getProperlyScaledImage("ikonice/projectnew.png", 16, 16));
		}
		
		else if (value instanceof Document ) {
			setIcon(ImageResizer.getProperlyScaledImage("ikonice/documentopen.png", 16, 16));
		}
		setFont(new Font("Segoe UI", Font.PLAIN, 14));
		return this;
	}
}
