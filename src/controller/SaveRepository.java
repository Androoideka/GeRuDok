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

public class SaveRepository {
	public void save(MPNode mpNode) {
		String fileName=mpNode.getFile();
		if(fileName==null) {
			saveAs(mpNode);
		}else {
			try {
				ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(new File(fileName)));
				ous.writeObject(mpNode);
				mpNode.setFile(new File(fileName).toString());
				mpNode.setChanged(false);
				ous.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void saveAs(MPNode mpNode) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		String fileName=mpNode.getFile();
		File file;
		if(!mpNode.getChanged()) {
			return;
		}
		if(fileName==null) {
			if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
				file=jfc.getSelectedFile();
				if(!file.getAbsolutePath().endsWith(".mp")) {
					file=new File(file+".mp");
				}
			}else {
				return;
			}
		}else {
			file=new File(fileName);
		}
		try {
			ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(file));
			ous.writeObject(mpNode);
			mpNode.setFile(file.toString());
			mpNode.setChanged(false);
			ous.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
