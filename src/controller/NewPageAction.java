package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import gui.DocumentView;
import gui.MainFrame;
import model.document.Page;
import model.workspace.MPNode;
import model.workspace.MPNodeFactory;

public class NewPageAction extends AbstractAction {
	DocumentView docView;
	
	public NewPageAction(DocumentView docView) {
		this.docView = docView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		docView.createNewPage(new Page());
	}
}
