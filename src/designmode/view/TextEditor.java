package designmode.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TextEditor extends Editor {
	private JTextPane tp;
	
	public TextEditor() {
		super();
		TextEditorToolbar tet=new TextEditorToolbar();
		add(tet, BorderLayout.NORTH);
		tp=new JTextPane();
		tp.setPreferredSize(new Dimension(250, 400));
		tp.setEditable(false);
		JScrollPane sp=new JScrollPane(tp);
		add(sp, BorderLayout.SOUTH);
	}
	
	public JTextPane getTP() {
		return tp;
	}
}
