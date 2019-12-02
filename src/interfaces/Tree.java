package interfaces;

import javax.swing.tree.MutableTreeNode;

public interface Tree {
	MutableTreeNode getSelectedNode();
	MutableTreeNode getRoot();
	void startEditing();
}
