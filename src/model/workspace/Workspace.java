package model.workspace;

import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Workspace implements TreeNode {
	private String name;
	private List<Project> prj;

	@Override
	public Enumeration<? extends TreeNode> children() {
		// TODO Auto-generated method stub
		return prj;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return prj.get(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return prj.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return prj.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}
