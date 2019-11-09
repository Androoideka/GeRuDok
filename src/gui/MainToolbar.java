package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;
import controller.NewDocumentAction;

public class MainToolbar extends JToolBar {
	public MainToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		add(ActionManager.getInstance().getNewProjectAction());
		
		addSeparator();
		
		add(ActionManager.getInstance().getNewDocumentAction());
		add(ActionManager.getInstance().getOpenDocumentAction());
		
		addSeparator();
		
		add(ActionManager.getInstance().getSaveAction());
		add(ActionManager.getInstance().getRenameAction());
		add(ActionManager.getInstance().getDeleteAction());
	}
}
