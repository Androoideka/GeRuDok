package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controller.OpenRepository;
import controller.SaveRepository;
import exceptionhandling.ExceptionHandler;
import model.workspace.MPNode;
import model.workspace.Workspace;

public class StartListener extends WindowAdapter {
	public void windowActivated(WindowEvent arg0) {
		File file=SaveRepository.getFile();
		Workspace wsPrev=null;
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			try {
				wsPrev=(Workspace)ois.readObject();
			}catch(ClassNotFoundException e1) {
				String value = ExceptionHandler.createDialog(new NoPreveousWorkspaceFoundException());
				int buttonClicked = Integer.parseInt(value);
				if(buttonClicked == JOptionPane.YES_OPTION) {
					OpenRepository open=new OpenRepository();
					open.switchWorkspace();
				}
				else {
					if(buttonClicked == JOptionPane.NO_OPTION) {
						
					}
				}
			}
			ois.close();
			MainFrame.getInstance().getWorkspaceTree().setRoot(wsPrev);
		}catch(FileNotFoundException e2) {
			String value = ExceptionHandler.createDialog(new NoPreveousWorkspaceFoundException());
			int buttonClicked = Integer.parseInt(value);
			if(buttonClicked == JOptionPane.YES_OPTION) {
				OpenRepository open=new OpenRepository();
				open.switchWorkspace();
			}
			else {
				if(buttonClicked == JOptionPane.NO_OPTION) {
					
				}
			}
		}catch(IOException e3) {
			e3.printStackTrace();
		}
	}
}
