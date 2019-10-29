package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static MainFrame instance = null;
	
	private MainMenu menu;
	
	private MainFrame() {
		setTitle("GeRuDok");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(new Dimension(screenSize.width/2, screenSize.height/2));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu = new MainMenu();
		setJMenuBar(menu);
		
		MainToolbar toolbar = new MainToolbar();
		add(toolbar, BorderLayout.NORTH);
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
}
