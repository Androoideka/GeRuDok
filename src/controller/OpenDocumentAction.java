package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class OpenDocumentAction extends MehanickoPrebacivanjeAction {
	
	public OpenDocumentAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/documentopen.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/documentopen.png", 24, 24));
		putValue(NAME, "Open document");
		putValue(SHORT_DESCRIPTION, "Open an existing document.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
