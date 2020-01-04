package designmode.view;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TextEditor extends Editor {
	public TextEditor() {
		super();
		TextEditorToolbar tet=new TextEditorToolbar();
		add(tet, BorderLayout.NORTH);
		JTextPane tp=new JTextPane();
		JScrollPane sp=new JScrollPane(tp);
		add(sp, BorderLayout.SOUTH);
	}
}
