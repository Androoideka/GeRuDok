package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;

import exceptionhandling.ExceptionHandler;
import gui.MainFrame;
import helpers.DocumentFileFIlter;
import model.workspace.MPNode;
import model.workspace.Workspace;

public class OpenRepository {
	private MPNode open() {
		MPNode mpNode=null;
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				try {
					mpNode=(MPNode)ois.readObject();
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				ois.close();
				
			}catch(FileNotFoundException e2) {
				e2.printStackTrace();
			}catch(IOException e3) {
				e3.printStackTrace();
			}
		}
		return mpNode;
	}

	public void openDocument() {
		MPNode mpNode=this.open();
		if(mpNode!=null) {
			MPNode mpParent=MainFrame.getInstance().getWorkspaceTree().getRoot();
			mpParent.insert(mpNode, mpParent.getChildCount());
		}
	}

	public void switchWorkspace() {
		MPNode mpNode=this.open();
		if(mpNode!=null) {
			MainFrame.getInstance().getWorkspaceTree().setRoot((Workspace)mpNode);
		}
	}
	
	public static Workspace openLocation() {
		File file=SaveRepository.getFile();
		Workspace ws=null;
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			try {
				ws=(Workspace)ois.readObject();
			}catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			ois.close();
		}catch(FileNotFoundException e2) {
			ExceptionHandler.createDialog(e2);
		}catch(IOException e3) {
			e3.printStackTrace();
		}
		return ws;
	}
}
