package gui;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class Palette extends JToolBar {

	public Palette() {
		super(SwingConstants.VERTICAL);
		ButtonGroup group = new ButtonGroup();
		
		for(AbstractAction a : ActionManager.getInstance().getPaletteActions()) {
			JToggleButton button = new JToggleButton(a);
			group.add(button);
			add(button);
		}
	}
}
