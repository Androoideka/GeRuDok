package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AboutDialog;
import gui.MainFrame;

public class AboutActionListener implements ActionListener {
	private MainFrame glavniProzor;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AboutDialog(glavniProzor);
	}
	
}
