package controller;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import exceptions.ExceptionHandler;
import exceptions.UnsavedWorkspaceException;
import view.MainFrame;
import workspace.model.MPNode;
import workspace.model.Repository;

public class CloseListener extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent arg0) {
		MainFrame frame = MainFrame.getInstance();
		MPNode ws = (MPNode) MainFrame.getInstance().getWorkspaceTree().getRoot();
		try {
			if (ws.isChanged()) {
				throw new UnsavedWorkspaceException();
			}
		} catch (UnsavedWorkspaceException e) {
			int value = ExceptionHandler.createOptionDialog(new UnsavedWorkspaceException());
			if (value == JOptionPane.CANCEL_OPTION) {
				frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			} else {
				if (value == JOptionPane.YES_OPTION) {
					Repository.getInstance().save(ws);
				}
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		}
	}

}
