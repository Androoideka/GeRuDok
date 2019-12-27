package view;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import exceptionhandling.ExceptionHandler;
import workspace.model.MPNode;
import workspace.model.Repository;
import workspace.model.Workspace;

public class StartListener extends WindowAdapter {
	public void windowOpened(WindowEvent arg0) {
		Workspace wsPrev = null;
		MPNode load = null;
		load = Repository.getInstance().open(Repository.prevWS);
		if(load instanceof Workspace) {
			wsPrev = (Workspace)load;
		}
		else {
			String value = ExceptionHandler.createDialog(new NoPreviousWorkspaceFoundException());
			int buttonClicked = Integer.parseInt(value);
			if(buttonClicked == JOptionPane.YES_OPTION) {
				Repository.getInstance().open();
			}
			else {
				if(buttonClicked == JOptionPane.NO_OPTION) {
					wsPrev = new Workspace();
				}
			}
		}
		MainFrame.getInstance().getWorkspaceTree().setRoot(wsPrev);
	}
}
