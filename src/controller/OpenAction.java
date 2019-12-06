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
import model.workspace.MPNode;

public class OpenAction extends AbstractAction {
	public OpenAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/projectopen.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/projectopen.png"));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open an existing project.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				MPNode mpNode=null;
				try {
					mpNode=(MPNode)ois.readObject();
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				MPNode mpParent=MainFrame.getInstance().getWorkspaceTree().getRoot();
				mpParent.setParent(mpParent);
				for(int i=0;i<mpNode.getChildCount();i++) {
					MPNode mpChild=(MPNode)mpNode.getChildAt(i);
					mpNode.insert(mpChild, mpNode.getChildCount());
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
