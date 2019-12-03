package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.tree.MutableTreeNode;

import gui.MainFrame;
import helpers.ImageResizer;

public class CloseTabAction extends AbstractAction {
	public CloseTabAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_CLOSE_BRACKET, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/tabclose.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/tabclose.png"));
		putValue(NAME, "Close");
		putValue(SHORT_DESCRIPTION, "Close a tab.");
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
