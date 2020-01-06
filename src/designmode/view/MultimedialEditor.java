package designmode.view;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MultimedialEditor extends Editor {
	private MultimedialEditorToolbar met;
	private BufferedImage img;
	private ImageIcon icon;
	private JLabel pic;
	
	public MultimedialEditor() {
		super();
		met=new MultimedialEditorToolbar();
		add(met, BorderLayout.NORTH);
		img=null;
		icon=null;
		pic=new JLabel(icon, SwingUtilities.CENTER);
		add(pic, BorderLayout.CENTER);
	}
	
	public MultimedialEditorToolbar getMultiToolbar() {
		return met;
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	public void setImage(BufferedImage img) {
		if(this.img!=null) {
			this.img=null;
		}
		this.img=img;
		icon=new ImageIcon(img);
		pic.setIcon(icon);
	}
}
