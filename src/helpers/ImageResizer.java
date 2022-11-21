package helpers;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageResizer {
	private static ImageResizer instance=null;
	
	private ImageResizer() {
		
	}
	public ImageIcon getProperlyScaledImage(String fileName, int width, int height) {
		if(fileName != null) {
			ImageIcon originalIcon = new ImageIcon("app/ikonice/" + fileName);
			ImageIcon scaledIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
			return scaledIcon;
		}
		else {
			System.out.println("Resource not found: " + fileName);
		}
		return null;
	}
	
	public ImageIcon loadSmallIcon(String fileName) {
		return getProperlyScaledImage(fileName, 16, 16);
	}
	
	public ImageIcon loadBigIcon(String fileName) {
		return getProperlyScaledImage(fileName, 24, 24);
	}
	
	public static ImageResizer getInstance() {
		if(instance==null) {
			instance=new ImageResizer();
		}
		return instance;
	}
}
