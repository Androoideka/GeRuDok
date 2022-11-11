package exceptions;

import javax.swing.JOptionPane;

import helpers.LoadFailCause;

public class OpenException extends OptionException {
    private OpenException(String title) {
        super(title, "Would you like to try opening a different file?",
                JOptionPane.ERROR_MESSAGE,
                JOptionPane.YES_NO_OPTION);
    }

    public static OptionException create(LoadFailCause cause, String type) {
        String title;
        switch (cause) {
            case FileNotFound:
                title = "Selected file does not exist";
                break;
            case ClassNotFound:
                title = "Selected file is not a recognised format";
                break;
            case WrongClass:
                title = "Selected file is not a " + type;
                break;
            default:
                title = "Selected file is inaccessible";
                break;
        }
        return new OpenException(title);
    }
}
