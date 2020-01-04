package designmode.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class Editor extends JFrame {
	
	public Editor() {
		setTitle("Slot content");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(new Dimension(screenSize.width/2, screenSize.height/2));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
