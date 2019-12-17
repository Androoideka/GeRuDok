package gui;

public class NoPreveousWorkspaceFoundException extends Exception {
	public NoPreveousWorkspaceFoundException() {
		super("No preveous context found.");
	}
}
