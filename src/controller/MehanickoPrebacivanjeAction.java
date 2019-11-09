package controller;

import java.awt.Image;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import helpers.ImageResizer;

public abstract class MehanickoPrebacivanjeAction extends AbstractAction {
	public Icon loadIcon(String fileName, int width, int height){
		/*if (fileName != null) {     
			ImageIcon originalIcon = new ImageIcon(fileName);
			ImageIcon scaledIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
			return scaledIcon;
	    } else {                                     
	        System.out.println("Resource not found: " + fileName);
	    }
		return null;*/
		return ImageResizer.getProperlyScaledImage(fileName, width, height);
	}
}
