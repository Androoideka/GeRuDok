package model.workspace;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Workspace implements TreeNode {
	private String name;
	private List<Project> prj;
	
	public Workspace() {
		super();
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return Collections.enumeration(prj);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return prj.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return prj.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return prj.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return null;
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
