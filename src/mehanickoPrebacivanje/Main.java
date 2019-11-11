package mehanickoPrebacivanje;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

import gui.MainFrame;
import helpers.ImageResizer;

public class Main {
	public static void main(String[] args) {
		/*try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (UnsupportedLookAndFeelException e) {
			
		}
	    catch (ClassNotFoundException e) {
	    	
	    }
	    catch (InstantiationException e) {
	    	
	    }
	    catch (IllegalAccessException e) {
	    	
	    }*/
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
	    
		UIManager.put("Tree.collapsedIcon", ImageResizer.getProperlyScaledImage("ikonice/chevron-right.png", 10, 10));
		UIManager.put("Tree.expandedIcon", ImageResizer.getProperlyScaledImage("ikonice/chevron-down.png", 10, 10));
		UIManager.put("MenuItem.acceleratorFont", new Font("Cambria", Font.ITALIC, 10));
		MainFrame glavniProzor = MainFrame.getInstance();
	}
}
