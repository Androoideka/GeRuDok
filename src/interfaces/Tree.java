package interfaces;

import model.workspace.MPNode;

public interface Tree {
	MPNode getSelectedNode();
	void resetSelectedNode();
	MPNode getRoot();
	void startEditing();
}
