package designmode.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

public class TextEditor extends Editor {
	private JTextPane tp;
	private StyledDocument document;
	
	public TextEditor() {
		super();
		TextEditorToolbar tet=new TextEditorToolbar();
		add(tet, BorderLayout.NORTH);
		document=new DefaultStyledDocument();
		tp=new JTextPane();
		tp.setPreferredSize(new Dimension(250, 400));
		tp.setEditable(false);
		JScrollPane sp=new JScrollPane(tp);
		add(sp, BorderLayout.SOUTH);
	}
	
	public JTextPane getTP() {
		return tp;
	}
	
	public StyledDocument getDoc() {
		return document;
	}
}
