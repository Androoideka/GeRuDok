package designmode.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

import designmode.controller.FontListener;
import designmode.controller.FontSizeListener;

public class TextEditor extends Editor {
	private JTextPane tp;
	private StyledDocument document;
	private String fontName;
	private int fontStyle=0;
	private int fontSize;
	private TextEditorToolbar tet;
	
	public TextEditor() {
		super();
		tet=new TextEditorToolbar();
		add(tet, BorderLayout.NORTH);
		tet.getCbfont().addActionListener(new FontListener(this));
		tet.getCbSize().addActionListener(new FontSizeListener(this));
		document=new DefaultStyledDocument();
		tp=new JTextPane();
		tp.setPreferredSize(new Dimension(250, 450));
		tp.setEditable(false);
		JScrollPane sp=new JScrollPane(tp);
		add(sp, BorderLayout.SOUTH);
	}
	
	public TextEditorToolbar getToolbar() {
		return tet;
	}
	
	public JTextPane getTP() {
		return tp;
	}
	
	public StyledDocument getDoc() {
		return document;
	}
	
	public String getFontName() {
		return fontName;
	}
	
	public void setFontName(String fontName) {
		this.fontName=fontName;
		tp.setFont(new Font(fontName, fontStyle, fontSize));
	}
	
	public int getFontStyle() {
		return fontStyle;
	}
	
	public void setFontStyle(int fontStyle) {
		this.fontStyle=fontStyle;
		tp.setFont(new Font(fontName, fontStyle, fontSize));
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize=fontSize;
		tp.setFont(new Font(fontName, fontStyle, fontSize)); 
	}
}
