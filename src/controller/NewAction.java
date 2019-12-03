package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.MPNode;

public class NewAction extends AbstractAction {

	public NewAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/documentnew.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/documentnew.png"));
		putValue(NAME, "New");
		putValue(SHORT_DESCRIPTION, "Create a new document.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object node = MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(node instanceof MPNode) {
			MPNode mpNode = (MPNode)node;
			mpNode.addChild();
		}
		else {
			MainFrame.getInstance().getWorkspaceTree().getRoot().addChild();
		}
	}
}
