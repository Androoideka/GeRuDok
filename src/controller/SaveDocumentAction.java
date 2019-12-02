package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import gui.MainFrame;
import helpers.ImageResizer;
import model.workspace.Document;
import model.workspace.Project;
import model.workspace.Workspace;

public class SaveDocumentAction extends AbstractAction {
	
	public SaveDocumentAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.loadSmallIcon("ikonice/save.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.loadBigIcon("ikonice/save.png"));
		putValue(NAME, "Save document");
		putValue(SHORT_DESCRIPTION, "Save document changes.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceTree().getRoot();
		Project p=ws.getCurrentProject();
		Document d=p.getCurrentDocument();
		File prjFile=p.getProjectFile();
		if(!d.isChanged()) {
			return;
		}
		if(d.getDocumentFile()==null) {
			if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
				prjFile=jfc.getSelectedFile();
			}else {
				return;
			}
		}
		try {
			ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(prjFile));
			ous.writeObject(d);
			d.setDocumentFile(prjFile);
			d.setChanged(false);
			ous.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}*/
	}
}
