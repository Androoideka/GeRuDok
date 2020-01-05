package designmode.view;

import java.awt.GraphicsEnvironment;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class TextEditorToolbar extends JToolBar {
	private JComboBox<String> cbFont;
	private JComboBox<Integer> cbSize;
	
	public TextEditorToolbar() {
		super(SwingConstants.HORIZONTAL);
		for(AbstractAction a : ActionManager.getInstance().getTextEditorActions()) {
			add(a);
		}
		String[] fonts=new String[100];
		fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		cbFont=new JComboBox<>(fonts);
		cbFont.setSelectedItem(fonts[26]);
		add(cbFont);
		Integer[] sizes=new Integer[76];
		for(int i=0;i<76;i++) {
			sizes[i]=i+2;
		}
		cbSize=new JComboBox<>(sizes);
		cbSize.setSelectedItem(sizes[14]);
		add(cbSize);
	}
	
	public JComboBox<String> getCbfont() {
		return cbFont;
	}
	
	public JComboBox<Integer> getCbSize(){
		return cbSize;
	}
}
