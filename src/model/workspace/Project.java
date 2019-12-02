package model.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class Project extends MPNode { //implements MutableTreeNode, IModelObserver, Serializable {
	//private String name;
	private Workspace ws;
	private List<Document> docs = new ArrayList<>();
	//private transient List<IViewObserver> viewObservers = new ArrayList<IViewObserver>();
	private String projectFile=null;
	
	public Project(Workspace ws) {
		setParent(ws);
		this.name = "project";
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
		return docs.size() == 0;
	}
	
	@Override
	public void insert(MutableTreeNode node, int index) {
		if(node instanceof Document) {
			docs.add(index, (Document)node);
		}
		notifyObservers(node);
	}

	@Override
	public void remove(int index) {
		docs.remove(index);
		notifyObservers(null);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if(node instanceof Document) {
			Document d = (Document)node;
			docs.remove(d);
		}
		notifyObservers(null);
	}

	@Override
	public void removeFromParent() {
		int index = ws.getIndex(this);
		ws.remove(this);
		ws = null;
		notifyObservers(new AtomicInteger(index));
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent instanceof Workspace) {
			ws = (Workspace)newParent;
		}
	}
	
	public String getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(String projectFile) {
		this.projectFile = projectFile;
	}

	@Override
	public void addChild() {
		this.insert(new Document(this), this.getChildCount());
	}
}
