package view;

public class UnsavedWorkspaceException extends Exception {

	public UnsavedWorkspaceException() {
		super("Workspace not saved");
	}
}
