package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.AboutDialog;

public class AboutAction extends AbstractAction {
	
	public AboutAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("about.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("about.png"));
		putValue(NAME, "About");
		putValue(SHORT_DESCRIPTION, "About mehanickoPrebacivanje");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AboutDialog.getInstance().setVisible(true);
	}
	
}
