package helpers;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class DocumentFileFIlter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().toLowerCase().endsWith(".mp"));
	}

	@Override
	public String getDescription() {
		return "Mehanicko Prebacivanje (*.mp)";
	}
	
}
