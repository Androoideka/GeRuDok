package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import gui.DocumentView;
import model.document.Page;

public class NewPageAction extends AbstractAction {
	DocumentView docView;
	
	public NewPageAction(DocumentView docView) {
		this.docView = docView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		docView.createNewPage(new Page());
		
		docView.validate();
		docView.repaint();
	}
}
