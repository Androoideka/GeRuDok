package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import designmode.view.MultimedialEditor;
import helpers.ImageResizer;
import helpers.PictureFileFilter;
import view.MainFrame;

public class ImportPictureAction extends AbstractAction {
	private MultimedialEditor me;
	
	public ImportPictureAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/import.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/import.png"));
		putValue(NAME, "Import");
		putValue(SHORT_DESCRIPTION, "Import a picture into the editor.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		me=MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getSelectionModel().getSlots().get(0).getMultiEditor();
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new PictureFileFilter());
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
			try {
				BufferedImage img=ImageIO.read(jfc.getSelectedFile());
				me.setImage(img);
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
