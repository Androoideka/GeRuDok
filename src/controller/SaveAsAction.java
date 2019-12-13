package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.MPNode;

public class SaveAsAction extends AbstractAction {
	public SaveAsAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/save.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/save.png"));
		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save changes.");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MPNode mpNode=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		SaveRepository sr=new SaveRepository();
		sr.saveAs(mpNode);
	}
}
