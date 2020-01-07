package workspace.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import helpers.ImageResizer;
import view.MainFrame;
import workspace.model.Document;
import workspace.model.MPNode;
import workspace.model.Project;
import workspace.model.Workspace;

public class DeleteAction extends AbstractAction {
	
	public DeleteAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //0 specifies no modifiers
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/delete.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/delete.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete an object.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MPNode mpNode=MainFrame.getInstance().getWorkspaceTree().getSelectedNode();
		if(mpNode!=null) {
			
			/*Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceTree().getRoot();
			Document backupDocument=null;
			ArrayList<Document> backupDocuments=null;
			if(mpNode instanceof Document || mpNode instanceof Project) {
				if(Workspace.backup==null) {
					Workspace.backup=new Project();
					Workspace.backup.setName("backup");
				}
				if(mpNode instanceof Document) {
					backupDocument=(Document) mpNode;
					//backupDocument.setParent(Workspace.backup);
				}else if(mpNode instanceof Project) {
					backupDocuments=new ArrayList<>();
					for (int i=0;i<mpNode.getChildCount();i++) {
						backupDocuments.add((Document) mpNode.getChildAt(i));
					}
				}
			}
			
			
			if(backupDocument!=null) {
				Workspace.backup.insert(backupDocument, Workspace.backup.getChildCount());
			}
			if(backupDocuments!=null) {
				for (Document document : backupDocuments) {
					Workspace.backup.insert(document, Workspace.backup.getChildCount());
				}
			}
			if(Workspace.backup!=null) {
				for(int i=0;i<Workspace.backup.getChildCount();i++) {
					String s=Workspace.backup.getChildAt(i).toString();
					System.out.println(s);
				}
				ws.insert(Workspace.backup, ws.getChildCount());
			}/*
			
			
			
			/*Project backup=Workspace.backup;
			if(mpNode instanceof Document || mpNode instanceof Project) {
				if(backup==null) {
					backup=new Project();
					backup.setName("backup");
					MainFrame.getInstance().getBackupTree().setRoot(backup);
					MainFrame.getInstance().getBackupTree().setVisible(true);
				}
				if(mpNode instanceof Document) {
					backup.insert((Document)mpNode, backup.getChildCount());
				}else if(mpNode instanceof Project) {
					for(int i=0;i<mpNode.getChildCount();i++) {
						backup.insert(mpNode.getChildAt(i), backup.getChildCount()+i);
					}
				}
			}*/
			
			/*Workspace ws=(Workspace)MainFrame.getInstance().getWorkspaceTree().getRoot();
			Project backup=ws.getBackup();
			if(mpNode instanceof Document) {
				ws.setDeletedDocuments(ws.getDeletedDocuments()+1);
				if(ws.getBackup()==null) {
					backup=new Project();
					backup.setName("backup");
					ws.insert(backup, ws.getChildCount());
				}
				backup.insert(mpNode, backup.getChildCount());
			}else if(mpNode instanceof Project) {
				ws.setDeletedDocuments(ws.getDeletedDocuments()+mpNode.getChildCount());
				if(backup==null) {
					backup=new Project();
					backup.setName("backup");
					ws.insert(backup, ws.getChildCount());
				}
				for(int i=0;i<mpNode.getChildCount();i++) {
					backup.insert(mpNode.getChildAt(i), backup.getChildCount()+i);
				}
			}
			ws.setBackup(backup);*/
			
			
			
			mpNode.removeFromParent();
			MainFrame.getInstance().getWorkspaceTree().resetSelectedNode();
			
		}
	}
}
