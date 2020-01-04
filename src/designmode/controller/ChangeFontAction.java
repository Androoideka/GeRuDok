package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;

public class ChangeFontAction extends AbstractAction {
	
	public ChangeFontAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/changefont.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/changefont.png"));
		putValue(NAME, "Change font");
		putValue(SHORT_DESCRIPTION, "Change the font of selected text.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
