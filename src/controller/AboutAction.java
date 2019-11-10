package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import gui.AboutDialog;
import gui.MainFrame;

public class AboutAction extends MehanickoPrebacivanjeAction {
	
	public AboutAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/about.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/about.png", 24, 24));
		putValue(NAME, "About");
		putValue(SHORT_DESCRIPTION, "About mehanickoPrebacivanje");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AboutDialog(MainFrame.getInstance());
	}
	
}
