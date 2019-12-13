package exceptionhandling;

import javax.swing.JOptionPane;

import gui.MainFrame;
import gui.workspace.InvalidNameException;

public class ExceptionHandler {

	public ExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public static String createDialog(Exception e) {
		if(e instanceof InvalidNameException) {
			return JOptionPane.showInputDialog(MainFrame.getInstance(),
					"Enter a valid name here, or click cancel to use the previously defined one",
					e.getMessage(),
					JOptionPane.WARNING_MESSAGE
					);
		}
		JOptionPane.showMessageDialog(MainFrame.getInstance(),
				"Unknown error",
				"Unknown error",
				JOptionPane.ERROR_MESSAGE);
		return null;
	}
}
