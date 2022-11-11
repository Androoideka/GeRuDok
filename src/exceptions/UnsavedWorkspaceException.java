package exceptions;

import javax.swing.JOptionPane;

public class UnsavedWorkspaceException extends OptionException {

	public UnsavedWorkspaceException() {
		super("Workspace not saved",
				"Would you like to save your workspace?",
				JOptionPane.QUESTION_MESSAGE,
				JOptionPane.YES_NO_CANCEL_OPTION);
	}
}
