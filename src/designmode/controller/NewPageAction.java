package designmode.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import document.model.Page;
import document.view.PageSlider;

public class NewPageAction extends AbstractAction {
	PageSlider pageSlider;
	
	public NewPageAction(PageSlider pageSlider) {
		this.pageSlider = pageSlider;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pageSlider.createNewPage(new Page());
		
		pageSlider.validate();
		pageSlider.repaint();
	}
}
