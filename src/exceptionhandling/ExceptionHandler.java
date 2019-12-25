package exceptionhandling;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.MainFrame;
import gui.NoPreveousWorkspaceFoundException;
import gui.UnsavedWorkspaceException;
import gui.workspace.InvalidNameException;

public class ExceptionHandler {
	
	public static String createDialog(Exception e) {
		JFrame frame = MainFrame.getInstance();
		if(e instanceof InvalidNameException) {
			return JOptionPane.showInputDialog(frame,
					"Enter a valid name here, or click cancel to use the previously defined one",
					e.getMessage(),
					JOptionPane.WARNING_MESSAGE
					);
		}
		else if(e instanceof UnsavedWorkspaceException) {
			String[] options = {"Yes", "No", "Cancel"};
			return JOptionPane.showOptionDialog(frame,
					"Would you like to save your workspace?",
					e.getMessage(),
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[2]
					) + "";
		}
		else if(e instanceof NoPreveousWorkspaceFoundException) {
			String[] options = {"Yes", "No"};
			return JOptionPane.showOptionDialog(frame,
					"Do you want to choose another existing workspace?",
					e.getMessage(),
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[1]
					) + "";
		}
		else if(e instanceof Exception) {
			JOptionPane.showMessageDialog(frame,
					e.getMessage(),
					e.getMessage(),
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
