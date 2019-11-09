package model.workspace;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class Page implements TreeNode {
	private String name;
	private Document doc;
	
	public Page(Document doc, String name) {
		this.doc=doc;
		this.name=name;
	}
	
	@Override
	public Enumeration<? extends TreeNode> children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		return -1;
	}

	@Override
	public TreeNode getParent() {
		return doc;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

}
