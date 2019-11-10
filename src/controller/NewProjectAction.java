package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import model.workspace.Project;
import model.workspace.Workspace;

public class NewProjectAction extends MehanickoPrebacivanjeAction {
	private static int br=1;
	
	public NewProjectAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/projectnew.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/projectnew.png", 24, 24));
		putValue(NAME, "New project");
		putValue(SHORT_DESCRIPTION, "Create a new project.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object w=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (w  instanceof Workspace || w==null) {
			w=MainFrame.getInstance().getWorkspaceModel().getRoot();
			Project p=new Project((Workspace)w, "project");
			((Workspace)w).addProject(p);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			//ovo bi mozda trebalo da se resava preko observera
			MainFrame.getInstance().getTabbedPane().addTab("Projekat "+br, new JPanel());
			br++;
		}
	}
}
