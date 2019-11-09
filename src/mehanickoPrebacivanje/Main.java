package mehanickoPrebacivanje;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.MainFrame;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
