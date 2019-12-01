package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import gui.MainFrame;
import model.workspace.Workspace;

public class SaveWorkspaceAction extends MehanickoPrebacivanjeAction {
	public SaveWorkspaceAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("ikonice/save.png", 16, 16));
		putValue(LARGE_ICON_KEY, loadIcon("ikonice/save.png", 24, 24));
		putValue(NAME, "Save workspace");
		putValue(SHORT_DESCRIPTION, "Save workspace changes.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceModel().getRoot();
		File prjFile=ws.getProjectFile();
		if(!ws.isChanged()) {
			return;
		}
		if(ws.getProjectFile()==null) {
			if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
				prjFile=jfc.getSelectedFile();
			}else {
				return;
			}
		}
		try {
			ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(prjFile));
			ous.writeObject(ws);
			ws.setProjectFile(prjFile);
			ws.setChanged(false);
			ous.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
