package gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static MainFrame instance = null;
	
	private MainFrame() {
		
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
}
