package designmode.view;

import java.awt.BorderLayout;

public class MultimedialEditor extends Editor {
	private MultimedialEditorToolbar met;
	
	public MultimedialEditor() {
		super();
		met=new MultimedialEditorToolbar();
		add(met, BorderLayout.NORTH);
	}
	
	public MultimedialEditorToolbar getMultiToolbar() {
		return met;
	}
}
