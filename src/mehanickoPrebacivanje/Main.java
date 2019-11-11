package mehanickoPrebacivanje;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.MainFrame;

public class Main {
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (UnsupportedLookAndFeelException e) {
			
		}
	    catch (ClassNotFoundException e) {
	    	
	    }
	    catch (InstantiationException e) {
	    	
	    }
	    catch (IllegalAccessException e) {
	    	
	    }
		MainFrame glavniProzor = MainFrame.getInstance();
	}
}
