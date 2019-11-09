package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Document implements TreeNode {
	private String name;
	private Project prj;
	private List<Page> pages=new ArrayList<Page>();
	
	public Document(Project prj, String name) {
		this.prj = prj;
		this.name = name;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return Collections.enumeration(pages);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return pages.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return pages.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return pages.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return prj;
	}

	@Override
	public boolean isLeaf() {
		return(pages.size()==0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addPage(Page p) {
		pages.add(p);
	}
	
	public String toString() {
		return name;
	}
}
