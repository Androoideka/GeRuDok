package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.MPNode;
import model.workspace.MPNodeFactory;

public class NewAction extends AbstractAction {

	public NewAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/new.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/new.png"));
		putValue(NAME, "New");
		putValue(SHORT_DESCRIPTION, "Create a new object.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MPNode node = MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(node==null) {
			node = MainFrame.getInstance().getWorkspaceTree().getRoot();
		}
		MPNodeFactory factory = MPNodeFactory.GenerateNodeFactory(node);
		if(factory != null) {
			node.insert(factory.deliverNode(), node.getChildCount());
		}
	}
}
