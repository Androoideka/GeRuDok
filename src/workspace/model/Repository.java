package workspace.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import exceptionhandling.ExceptionHandler;
import helpers.DocumentFileFIlter;
import view.MainFrame;

public class Repository {
	public static File prevWS=new File("prevWS.loc");
	public static Repository instance = null;

	private Repository() {
		
	}
	
	private void save(MPNode mpNode, File file) {
		try {
			ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(file));
			ous.writeObject(mpNode);
			mpNode.setFile(file.toString());
			mpNode.setChanged(false);
			if(mpNode instanceof Workspace) {
				saveLocal((Workspace)mpNode);
			}
			ous.close();
		}catch(FileNotFoundException e){
			ExceptionHandler.createDialog(e);
		}catch(IOException e){
			ExceptionHandler.createDialog(e);
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
			save(mpNode, file);
		}else {
			return;
		}
	}
	
	private void saveLocal(Workspace ws) {
		try {
			ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(prevWS));
			ous.writeObject(ws);
			ous.close();
		}catch(FileNotFoundException e){
			ExceptionHandler.createDialog(e);
		}catch(IOException e){
			ExceptionHandler.createDialog(e);
		}
	}
	
	public MPNode open(File file) {
		MPNode mpNode=null;
		try {
			
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			try {
				mpNode=(MPNode)ois.readObject();
			}catch(ClassNotFoundException e1) {
				ExceptionHandler.createDialog(e1);
			}
			ois.close();
		}catch(FileNotFoundException e2) {
			ExceptionHandler.createDialog(e2);
		}catch(IOException e3) {
			ExceptionHandler.createDialog(e3);
		}
		return mpNode;
	}
	
	public MPNode open() {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			return open(jfc.getSelectedFile());
		}
		return null;
	}

	public static Repository getInstance() {
		if(instance == null) {
			instance = new Repository();
		}
		return instance;
	}
}
