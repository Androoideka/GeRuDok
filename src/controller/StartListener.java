package controller;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import helpers.LoadContext;
import helpers.LoadPurpose;
import view.MainFrame;
import workspace.model.Repository;
import workspace.model.Workspace;

public class StartListener extends WindowAdapter {
	public void windowOpened(WindowEvent arg0) {
		LoadContext<Workspace> context = new LoadContext<>(Workspace.class, LoadPurpose.PREV);
		context.setFile(Repository.prevWS);
		Workspace wsPrev = Repository.getInstance().<Workspace>open(context);
		if (wsPrev == null) {
			wsPrev = new Workspace();
		}
		MainFrame.getInstance().getWorkspaceTree().setRoot(wsPrev);
	}
}
