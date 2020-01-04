package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;
import workspace.model.Document;
import workspace.model.MPNode;

public class UnlinkAction extends AbstractAction {

	public UnlinkAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/unlink.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/unlink.png"));
		putValue(NAME, "Unlink document");
		putValue(SHORT_DESCRIPTION, "Unlink a document from other documents. Any further changes to that document's contents will not be seen in other documents.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MPNode mpNode=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(mpNode instanceof Document) {
			Document d = (Document)mpNode;
			d.unlink();
		}
	}
}
