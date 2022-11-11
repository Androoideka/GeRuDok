package exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.MainFrame;

public class ExceptionHandler {

	public static void createDialog(Exception e) {
		JFrame frame = MainFrame.getInstance();
		JOptionPane.showMessageDialog(frame,
				"Unrecognised exception.",
				e.getMessage(),
				JOptionPane.ERROR_MESSAGE);
	}

	public static void createMessageDialog(DialogException e) {
		JFrame frame = MainFrame.getInstance();
		JOptionPane.showMessageDialog(frame,
				e.getMessage(),
				e.getTitle(),
				e.getSeverity());
	}

	public static String createInputDialog(DialogException e) {
		JFrame frame = MainFrame.getInstance();
		return JOptionPane.showInputDialog(frame,
				e.getMessage(),
				e.getTitle(),
				e.getSeverity());
	}

	public static int createOptionDialog(OptionException e) {
		JFrame frame = MainFrame.getInstance();
		String[] optionArray = e.getOptions();
		return JOptionPane.showOptionDialog(frame,
				e.getMessage(),
				e.getTitle(),
				e.getOptionType(),
				e.getSeverity(),
				null,
				optionArray,
				optionArray.length);
	}
}
