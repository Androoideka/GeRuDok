package exceptions;

public abstract class DialogException extends Exception {
    private String title;
    private int severity;

    public DialogException(String title, String message, int severity) {
        super(message);
        this.title = title;
        this.severity = severity;
    }

    public String getTitle() {
        return title;
    }

    public int getSeverity() {
        return severity;
    }
}
