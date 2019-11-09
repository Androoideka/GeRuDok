package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import gui.AboutDialog;
import gui.MainFrame;

public class AboutActionListener extends MehanickoPrebacivanjeAction {
	private MainFrame glavniProzor;
	
	public AboutActionListener() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/about.png", 24, 24));
		putValue(NAME, "About");
		putValue(SHORT_DESCRIPTION, "About mehanickoPrebacivanje");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AboutDialog(glavniProzor);
	}
	
}
