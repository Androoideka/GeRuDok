package mehanickoPrebacivanje;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import helpers.ImageResizer;
import view.MainFrame;

public class Main {
	public static void main(String[] args) {
		System.setProperty("awt.useSystemAAFontSettings","on");
		System.setProperty("swing.aatext", "true");
		
		java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements()) {
	      Object key = keys.nextElement();
	      Object value = UIManager.get (key);
	      if (value instanceof javax.swing.plaf.FontUIResource) {
	    	  FontUIResource oldF = (FontUIResource)value;
	    	  FontUIResource f = new javax.swing.plaf.FontUIResource("Segoe UI",oldF.getStyle(),oldF.getSize() + 2);
	    	  UIManager.put (key, f);
	      }
	    }
	    
		UIManager.put("Tree.collapsedIcon", ImageResizer.getInstance().getProperlyScaledImage("ikonice/chevron-right.png", 10, 10));
		UIManager.put("Tree.expandedIcon", ImageResizer.getInstance().getProperlyScaledImage("ikonice/chevron-down.png", 10, 10));
		UIManager.put("MenuItem.acceleratorFont", new Font("Cambria", Font.ITALIC, 10));
		MainFrame glavniProzor = MainFrame.getInstance();
		glavniProzor.setVisible(true);
	}
}
