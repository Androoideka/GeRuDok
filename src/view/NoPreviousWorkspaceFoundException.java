package view;

public class NoPreviousWorkspaceFoundException extends Exception {
	public NoPreviousWorkspaceFoundException() {
		super("No preveous context found.");
	}
}
