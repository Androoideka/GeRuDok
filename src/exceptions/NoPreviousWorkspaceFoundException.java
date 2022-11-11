package exceptions;

import javax.swing.JOptionPane;

import helpers.LoadFailCause;

public class NoPreviousWorkspaceFoundException extends OptionException {
	private NoPreviousWorkspaceFoundException(String title, String message, int severity) {
		super(title, message, severity, JOptionPane.YES_NO_OPTION);
	}

	public static OptionException create(LoadFailCause cause) {
		String title = "No previous context found";
		String message = "Do you want to choose another workspace?";
		int severity = JOptionPane.QUESTION_MESSAGE;
		switch (cause) {
			case FileNotFound:
				message = "Do you want to choose a workspace?";
				break;
			case ClassNotFound:
				title = "Previous context was made on an older version or is corrupted";
				severity = JOptionPane.WARNING_MESSAGE;
				break;
			case WrongClass:
				title = "Found previous context is not a workspace";
				break;
			case IO:
				title = "Previous context was inaccessible";
				break;
		}
		return new NoPreviousWorkspaceFoundException(title, message, severity);
	}
}
