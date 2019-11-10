package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import gui.MainFrame;
import model.workspace.Document;
import model.workspace.Page;
import model.workspace.Project;

public class DeleteAction extends MehanickoPrebacivanjeAction {
	
	public DeleteAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, loadIcon("ikonice/delete.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/delete.png", 24, 24));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete an object.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object node=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		MutableTreeNode tNode=(MutableTreeNode)node;
		if (node instanceof Project || node instanceof Document || node instanceof Page) {
			MutableTreeNode tParentNode=(MutableTreeNode)tNode.getParent();
			tParentNode.remove(tNode);
		}
	}
}
