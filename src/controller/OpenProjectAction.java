package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class OpenProjectAction extends MehanickoPrebacivanjeAction {

	public OpenProjectAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/projectopen.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/projectopen.png", 24, 24));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open an existing project.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
