package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import designmode.view.TextEditor;

public class FontSizeListener implements ActionListener {
	private TextEditor te;
	
	public FontSizeListener(TextEditor te) {
		this.te=te;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Integer size=(Integer)te.getToolbar().getCbSize().getSelectedItem();
		te.setFontSize(size);
	}
}
