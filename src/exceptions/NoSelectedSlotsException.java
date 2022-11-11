package exceptions;

import javax.swing.JOptionPane;

public class NoSelectedSlotsException extends DialogException {
	public NoSelectedSlotsException() {
		super("No selected slots",
				"Select a slot to continue with this operation.",
				JOptionPane.WARNING_MESSAGE);
	}
}
