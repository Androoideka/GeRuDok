package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import designmode.view.TextEditor;

public class FontListener implements ActionListener {
	private TextEditor te;
	
	public FontListener(TextEditor te) {
		this.te=te;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String font=(String)te.getToolbar().getCbfont().getSelectedItem();
		te.setFontName(font);
	}

}
