package designmode.view;

import java.awt.BorderLayout;

public class TextEditor extends Editor {
	public TextEditor() {
		super();
		TextEditorToolbar tet=new TextEditorToolbar();
		add(tet, BorderLayout.NORTH);
	}
}
