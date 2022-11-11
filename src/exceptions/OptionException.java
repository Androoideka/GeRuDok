package exceptions;

import javax.swing.JOptionPane;

public abstract class OptionException extends DialogException {
    private int optionType;

    public OptionException(String title, String message, int severity, int optionType) {
        super(title, message, severity);
        this.optionType = optionType;
    }

    public int getOptionType() {
        return optionType;
    }

    public String[] getOptions() {
        switch (optionType) {
            case JOptionPane.YES_NO_OPTION:
                return new String[] { "Yes", "No" };
            case JOptionPane.YES_NO_CANCEL_OPTION:
                return new String[] { "Yes", "No", "Cancel" };
            default:
                return new String[] {};
        }
    }
}
