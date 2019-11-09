package helpers;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageResizer {
	public static ImageIcon getProperlyScaledImage(String fileName, int width, int height) {
		if(fileName != null) {
			ImageIcon originalIcon = new ImageIcon(fileName);
			ImageIcon scaledIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
			return scaledIcon;
		}
		else {
			System.out.println("Resource not found: " + fileName);
		}
		return null;
	}
}
