package controller;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class MehanickoPrebacivanjeAction extends AbstractAction {
	public Icon loadIcon(String fileName, int width, int height){
		if (fileName != null) {                      
	        return new ImageIcon(fileName, width, height);
	    } else {                                     
	        System.out.println("Resource not found: " + fileName);
	    }
		return null;
	}
}
