package interfaces;

import model.workspace.MPNode;
import model.workspace.Workspace;
import observer.IViewObserver;

public interface IWorkspaceView extends IViewObserver {
	MPNode getSelectedNode();
	void resetSelectedNode();
	MPNode getRoot();
	void startEditing();
	void showMenuAtLocation(int x, int y);
	void setRoot(Workspace ws);
}
