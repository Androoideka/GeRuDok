package helpers;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PictureFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg") || f.getName().toLowerCase().endsWith(".png"));
	}

	@Override
	public String getDescription() {
		return "Picture (*pic)"; 
	}
 
}
