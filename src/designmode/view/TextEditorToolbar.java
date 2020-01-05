package designmode.view;

import java.awt.GraphicsEnvironment;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class TextEditorToolbar extends JToolBar {
	public TextEditorToolbar() {
		super(SwingConstants.HORIZONTAL);
		for(AbstractAction a : ActionManager.getInstance().getTextEditorActions()) {
			add(a);
		}
		String[] fonts=new String[100];
		fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JComboBox<String> cbFont=new JComboBox<>(fonts);
		add(cbFont);
		Integer[] sizes=new Integer[76];
		for(int i=0;i<76;i++) {
			sizes[i]=i+2;
		}
		JComboBox<Integer> cbSize=new JComboBox<>(sizes);
		add(cbSize);
	}
}
