package gui.workspace;

import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import exceptionhandling.ExceptionHandler;
import model.workspace.MPNode;

public class WorkspaceTreeEditor extends DefaultTreeCellEditor implements ActionListener {

	private MPNode node;
	private JTextField field=null;
	public WorkspaceTreeEditor(JTree tree, DefaultTreeCellRenderer renderer) {
		super(tree, renderer);
	}
	
	public Component getTreeCellEditorComponent(JTree tree, Object node, boolean isSelected, boolean isExpanded, boolean isLeaf, int row) {
		this.node=(MPNode)node;
		field=new JTextField(node.toString());
		field.addActionListener(this);
		return field;
	}
	
	public boolean canEditImmediately(EventObject event) {
		if(event instanceof MouseEvent) {
			return ((MouseEvent)event).getClickCount() == 3;
		}
		return super.canEditImmediately(event);
	}
	
	public void actionPerformed(ActionEvent event){
		String newName = event.getActionCommand();
		try {
			if(field == null) return;
			if(newName.isEmpty() || !Character.isLetterOrDigit(newName.charAt(0))) {
				throw new InvalidNameException();
			}
		}
		catch (NullPointerException e) {
			newName = node.getName();
		}
		catch (Exception e) {
			newName = ExceptionHandler.createDialog(e);
			if(newName == null || newName.isEmpty() || !Character.isLetterOrDigit(newName.charAt(0))) {
				newName = node.getName();
			}
		}
		finally {
			field.setText(newName);
			node.setName(newName);
			stopCellEditing();
		}
	}
}
