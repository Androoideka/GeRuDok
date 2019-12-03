package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.tree.MutableTreeNode;

import gui.MainFrame;
import helpers.ImageResizer;

public class DeleteAction extends AbstractAction {
	
	public DeleteAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/delete.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/delete.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete an object.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object node=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if(node instanceof MutableTreeNode) {
			MutableTreeNode tNode=(MutableTreeNode)node;
			tNode.removeFromParent();
			MainFrame.getInstance().getWorkspaceTree().resetSelectedNode();;
		}
	}
}
