package workspace.view;

public class InvalidNameException extends Exception {

	public InvalidNameException() {
		super("Invalid input, must start with an alphanumeric");
	}
}
