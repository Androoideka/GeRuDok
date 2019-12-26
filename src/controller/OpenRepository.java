package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;

import exceptionhandling.ExceptionHandler;
import helpers.DocumentFileFIlter;
import view.MainFrame;
import workspace.model.MPNode;
import workspace.model.Workspace;

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
				ExceptionHandler.createDialog(e2);
			}catch(IOException e3) {
				ExceptionHandler.createDialog(e3);
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
}
