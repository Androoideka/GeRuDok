package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.Project;
import model.workspace.Workspace;

public class OpenWorkspaceAction extends AbstractAction {
	
	public OpenWorkspaceAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/workspaceopen.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/workspaceopen.png"));
		putValue(NAME, "Open workspace");
		putValue(SHORT_DESCRIPTION, "Open a new workspace.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				Workspace ws=null;
				try {
					ws=(Workspace)ois.readObject();
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				ws=(Workspace)MainFrame.getInstance().getWorkspaceTree().getRoot();
				for(int i=0;i<ws.getChildCount();i++) {
					Project p=new Project(ws);
					ws.insert(p, ws.getChildCount());
				}
				ois.close();
			}catch(FileNotFoundException e2) {
				e2.printStackTrace();
			}catch(IOException e3) {
				e3.printStackTrace();
			}
		}
	}
}
