package designmode.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Editor extends JFrame {
	
	public Editor() {
		setTitle("Slot content");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(new Dimension(screenSize.width/4, screenSize.height/4));
	}
}
