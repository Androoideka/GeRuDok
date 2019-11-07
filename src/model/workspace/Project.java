package model.workspace;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Project implements TreeNode {
	private String name;
	private Workspace ws;
	private List<Document> docs;
	
	public Project(Workspace ws, String name) {
		this.ws = ws;
		this.name = name;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return Collections.enumeration(docs);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return docs.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return docs.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return docs.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return ws;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public String toString() {
		return name;
	}

}
