package gui.workspace;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.workspace.Document;
import model.workspace.Project;
import model.workspace.Workspace;

public class WorkspaceTreeEditor extends DefaultTreeCellEditor implements ActionListener {

	private Object node;
	private JTextField field=null;
	public WorkspaceTreeEditor(JTree tree, DefaultTreeCellRenderer renderer) {
		super(tree, renderer);
	}
	
	public Component getTreeCellEditorComponent(JTree tree, Object node, boolean isSelected, boolean isExpanded, boolean isLeaf, int row) {
		this.node=node;
		field=new JTextField(node.toString());
		field.addActionListener(this);
		return field;
	}
	
	public void actionPerformed(ActionEvent event){
		stopCellEditing();
        if (node instanceof Workspace) {
                ((Workspace)node).setName(event.getActionCommand());
        }
        else if (node instanceof Project) {
                ((Project)node).setName(event.getActionCommand());
        }
        else if(node instanceof Document) {
                ((Document)node).setName(event.getActionCommand());
        }
	}
}
