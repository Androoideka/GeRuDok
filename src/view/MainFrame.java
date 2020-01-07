package view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import controller.CloseListener;
import controller.StartListener;
import document.view.WorkspaceTabbedMenu;
//import workspace.model.Project;
//import workspace.model.Workspace;
import workspace.view.BackupTree;
import workspace.view.WorkspaceTree;

public class MainFrame extends JFrame implements ClipboardOwner {
	private static MainFrame instance = null;
	
	private MainMenu menu;
	private WorkspaceTree wst;
	private BackupTree bt;
	
	private WorkspaceTabbedMenu wtb;
	
	private Clipboard clipboard=new Clipboard("Clipboard mehanickog prebacivanja");
	private MainFrame() {
		setTitle("GeRuDok");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(new Dimension(screenSize.width, screenSize.height));
		
		menu = new MainMenu();
		setJMenuBar(menu);
		
		MainToolbar toolbar = new MainToolbar();
		add(toolbar, BorderLayout.NORTH);
		
		wst=new WorkspaceTree();
		//bt=new BackupTree();
		//bt.setRoot(Workspace.backup);
		//bt.setVisible(true);
		//bt.setRoot(new Project());
		
		JScrollPane treePanel=new JScrollPane(wst);
		//JScrollPane backupPanel=new JScrollPane(bt);
		
		//JSplitPane razdela=new JSplitPane(JSplitPane.VERTICAL_SPLIT, treePanel, backupPanel);
		//add(razdela, BorderLayout.CENTER);
		//razdela.setDividerLocation(screenSize.height/2);
		
		wtb = new WorkspaceTabbedMenu();
		add(wtb, BorderLayout.CENTER);
		
		//JSplitPane podela=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, razdela, wtb);
		//add(podela, BorderLayout.CENTER);
		//podela.setDividerLocation(screenSize.width/16);
		

        JSplitPane podela=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePanel, wtb);
        add(podela, BorderLayout.CENTER);
        podela.setDividerLocation(screenSize.width/16);
		
		addWindowListener(new StartListener());
		addWindowListener(new CloseListener());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public WorkspaceTree getWorkspaceTree() {
		return wst;
	}
	
	//public BackupTree getBackupTree() {
	//	return bt;
	//}
	
	public WorkspaceTabbedMenu getWorkspaceTabbedMenu() {
		return wtb;
	}

	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public Clipboard getClipboard() {
		return clipboard;
	}
}
