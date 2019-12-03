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
import helpers.ImageResizer;
import model.workspace.Document;
import model.workspace.Page;
import model.workspace.Workspace;

public class OpenDocumentAction extends AbstractAction {
	
	public OpenDocumentAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/documentopen.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/documentopen.png"));
		putValue(NAME, "Open document");
		putValue(SHORT_DESCRIPTION, "Open an existing document.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				Document d=null;
				try {
					d=(Document)ois.readObject();
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceTree().getRoot();
				ws.insert(d, ws.getChildCount());
				for(int i=0;i<d.getChildCount();i++) {
					Page p=new Page(d);
					d.insert(p, d.getChildCount());
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
