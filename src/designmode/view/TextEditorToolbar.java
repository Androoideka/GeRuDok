package designmode.view;

import javax.swing.AbstractAction;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class TextEditorToolbar extends JToolBar {
	public TextEditorToolbar() {
		super(SwingConstants.HORIZONTAL);
		for(AbstractAction a : ActionManager.getInstance().getTextEditorActions()) {
			add(a);
		}
	}
}
