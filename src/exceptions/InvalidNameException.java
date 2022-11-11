package exceptions;

import javax.swing.JOptionPane;

public class InvalidNameException extends DialogException {

	public InvalidNameException() {
		super("Invalid input, must start with an alphanumeric",
				"Enter a valid name here, or click cancel to use the previously defined one.",
				JOptionPane.WARNING_MESSAGE);
	}
}
