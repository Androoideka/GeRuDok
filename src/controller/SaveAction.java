package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class SaveAction extends MehanickoPrebacivanjeAction {
	
	public SaveAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/save.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/save.png", 24, 24));
		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save all changes.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
