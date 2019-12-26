package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import controller.OpenRepository;
import helpers.ImageResizer;

public class OpenAction extends AbstractAction {
	public OpenAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/projectopen.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/projectopen.png"));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open an existing project.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		OpenRepository or=new OpenRepository();
		or.openDocument();
	}
}
