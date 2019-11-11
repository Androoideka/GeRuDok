package mehanickoPrebacivanje;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		UIManager.put("Tree.collapsedIcon", ImageResizer.getProperlyScaledImage("ikonice/chevron-right.png", 10, 10));
		UIManager.put("Tree.expandedIcon", ImageResizer.getProperlyScaledImage("ikonice/chevron-down.png", 10, 10));
		UIManager.put("MenuItem.acceleratorFont", new Font("Cambria", Font.ITALIC, 8));
		MainFrame glavniProzor = MainFrame.getInstance();
	}
}
