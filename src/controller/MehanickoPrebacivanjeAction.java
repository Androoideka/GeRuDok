package controller;

import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class MehanickoPrebacivanjeAction extends AbstractAction {
	public Icon loadIcon(String fileName){
		if (fileName != null) {                      
	        return new ImageIcon(fileName);
	    } else {                                     
	        System.out.println("Resource not found: " + fileName);
	    }
		return null;
	}
}
