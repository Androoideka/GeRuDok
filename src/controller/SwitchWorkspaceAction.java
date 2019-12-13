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
import helpers.DocumentFileFIlter;
import helpers.ImageResizer;
import model.workspace.Workspace;

public class SwitchWorkspaceAction extends AbstractAction {
	public SwitchWorkspaceAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/workspaceopen.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/workspaceopen.png"));
		putValue(NAME, "Switch workspace");
		putValue(SHORT_DESCRIPTION, "Switch current workspace.");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				Workspace ws=null;
				try {
					ws=(Workspace) ois.readObject();
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				MainFrame.getInstance().getWorkspaceTree().setRoot(ws);
				ois.close();
			}catch(FileNotFoundException e2) {
				e2.printStackTrace();
			}catch(IOException e3) {
				e3.printStackTrace();
			}
		}
	}
	
}
