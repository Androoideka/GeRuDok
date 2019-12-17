package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import gui.MainFrame;
import helpers.DocumentFileFIlter;
import model.workspace.MPNode;
import model.workspace.Workspace;

public class SaveRepository {
	private static File prevWS=new File("prevWS.loc");
	
	public static File getFile() {
		return prevWS;
	}
	
	private void save(MPNode mpNode, File file) {
		try {
			ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(file));
			ous.writeObject(mpNode);
			mpNode.setFile(file.toString());
			mpNode.setChanged(false);
			if(mpNode instanceof Workspace) {
				saveLocation((Workspace)mpNode);
			}
			ous.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void save(MPNode mpNode) {
		String fileName=mpNode.getFile();
		if(fileName==null) {
			saveAs(mpNode);
		}else {
			File file=new File(fileName);
			save(mpNode, file);
		}
	}
	
	public void saveAs(MPNode mpNode) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		File file;
		if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			file=jfc.getSelectedFile();
			if(!file.getAbsolutePath().endsWith(".mp")) {
				file=new File(file+".mp");
			}
		}else {
			return;
		}
		save(mpNode, file);
	}
	
	public static void saveLocation(Workspace ws) {
		try {
			ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(prevWS));
			ous.writeObject(ws);
			ous.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
