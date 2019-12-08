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
import model.workspace.MPNode;

public class SaveAsAction extends AbstractAction {
	public SaveAsAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/save.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/save.png"));
		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save changes.");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		Object node=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(node instanceof MPNode) {
			MPNode mpNode=(MPNode)node;
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
}
