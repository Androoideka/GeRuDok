package designmode.view;

import javax.swing.AbstractAction;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class MultimedialEditorToolbar extends JToolBar {
	
	public MultimedialEditorToolbar() {
		super(SwingConstants.HORIZONTAL);
		for(AbstractAction a : ActionManager.getInstance().getMultimedialEditorActions()) {
			add(a);
		}
	}
}
