package workspace.view;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import controller.ActionManager;

public class TreePopupMenu extends JPopupMenu {

	public TreePopupMenu(Object node) {
		super();

		add(ActionManager.getInstance().getNewAction());
		for(AbstractAction a : ActionManager.getInstance().getEditActions()) {
			add(a);
		}
	}
}
