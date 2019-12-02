package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class Workspace extends MPNode {;
	private List<Project> prj = new ArrayList<>();
	
	public Workspace() {
		this.name = "Workspace";
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
		return prj.size() == 0;
	}
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Project) {
			prj.add((Project)node);
		}
		notifyObservers(node);
	}

	@Override
	public void remove(int index) {
		prj.remove(index);
		notifyObservers(null);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Project) {
			Project p = (Project)node;
			prj.remove(p);
		}
		notifyObservers(null);
	}

	@Override
	public void removeFromParent() {
		return;
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		return;
	}
	
	@Override
	public void addChild() {
		this.insert(new Project(this), this.getChildCount());
	}
}
