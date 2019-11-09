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
		
		/*JButton newBtn = new JButton();
		newBtn.setToolTipText("Create a new document");
		newBtn.setIcon(new ImageIcon("images/documentnew.png"));
		add(newBtn);*/
		
		JButton openBtn = new JButton();
		openBtn.setToolTipText("Open an existing document");
		openBtn.setIcon(new ImageIcon("images/document64.png"));
		add(openBtn);
		
		JButton saveBtn = new JButton();
		saveBtn.setToolTipText("Save changes to the project");
		saveBtn.setIcon(new ImageIcon("images/save64.png"));
		//saveBtn.setIcon(new ImageIcon((new ImageIcon("images/save64.png")).getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));	 moguce resenje za prevelike ikonice
		add(saveBtn);
	}
}
