package interfaces;

import model.workspace.MPNode;
import observer.IViewObserver;

public interface IWorkspaceView extends IViewObserver {
	MPNode getSelectedNode();
	void resetSelectedNode();
	MPNode getRoot();
	void startEditing();
}
