package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import gui.MainFrame;
import model.workspace.Document;
import model.workspace.Project;
import model.workspace.Workspace;

public class OpenProjectAction extends MehanickoPrebacivanjeAction {

	public OpenProjectAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/projectopen.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/projectopen.png", 24, 24));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open an existing project.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				Project p=null;
				try {
					p=(Project)ois.readObject();
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceModel().getRoot();
				ws.insert(p, ws.getChildCount());
				for(int i=0;i<p.getChildCount();i++) {
					Document d=new Document(p, "document");
					p.insert(d, p.getChildCount());
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
