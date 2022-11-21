package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;
import workspace.model.Document;
import workspace.model.MPNode;

public class LinkAction extends AbstractAction {
	
	private Document firstSelected = null;
	private boolean operationStarted = false;

	public LinkAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("link.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("link.png"));
		putValue(NAME, "Link document");
		putValue(SHORT_DESCRIPTION, "Link a document to another document.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MPNode mpNode=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(mpNode instanceof Document) {
			Document d = (Document)mpNode;
			if(!operationStarted) {
				firstSelected = d;
				operationStarted = true;
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Select another document to link with the current document. The contents of this document will be overwritten by the other one.");
			}
			else {
				firstSelected.link(d);
				operationStarted = false;
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Your documents are now linked. Any changes you make in one document will affect the other.");
			}
		}
	}
}
