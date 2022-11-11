package exceptions;

import javax.swing.JOptionPane;

import helpers.LoadFailCause;

public class SaveException extends OptionException {
    public SaveException(String title) {
        super(title,
                "Would you like to try saving to a different location?",
                JOptionPane.ERROR_MESSAGE,
                JOptionPane.YES_NO_CANCEL_OPTION);
    }

    public static OptionException create(LoadFailCause cause) {
        String title = "Unable to save because desired location is inaccessible";
        switch (cause) {
            case FileNotFound:
                title = "Unable to save because given path is invalid";
                break;
            default:
                break;
        }
        return new SaveException(title);
    }
}
