package controller;

import java.awt.Image;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import helpers.ImageResizer;

public abstract class MehanickoPrebacivanjeAction extends AbstractAction {
	public Icon loadIcon(String fileName, int width, int height){
		return ImageResizer.getProperlyScaledImage(fileName, width, height);
	}
}
