package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.tree.MutableTreeNode;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.Document;
import model.workspace.Page;
import model.workspace.Project;

public class DeleteAction extends AbstractAction {
	
	public DeleteAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.loadSmallIcon("ikonice/delete.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.loadBigIcon("ikonice/delete.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete an object.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object node=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		MutableTreeNode tNode=(MutableTreeNode)node;
		if (node instanceof Project || node instanceof Document || node instanceof Page) {
			tNode.removeFromParent();
			MainFrame.getInstance().getWorkspaceTree().setSelectionPath(null);
		}
	}
}
