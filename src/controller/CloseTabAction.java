package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import gui.WorkspaceTabbedMenu;
import helpers.ImageResizer;
import model.workspace.Document;
import model.workspace.MPNode;

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
		MPNode mpNode=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(mpNode instanceof Document && mpNode!=null) {
			int index=mpNode.getParent().getIndex(mpNode);
			WorkspaceTabbedMenu wtb=MainFrame.getInstance().getWorkspaceTabbedMenu(); 
			wtb.removeTabAt(index);
			MainFrame.getInstance().getWorkspaceTree().resetSelectedNode();;
		}
	}
}
