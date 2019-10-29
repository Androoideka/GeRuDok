package gui;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MainToolbar extends JToolBar {
	public MainToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		JButton newBtn = new JButton();
		newBtn.setToolTipText("Create a new document");
		add(newBtn);
		
		JButton openBtn = new JButton();
		openBtn.setToolTipText("Open an existing document");
		add(openBtn);
	}
}
