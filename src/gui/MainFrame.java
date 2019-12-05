package gui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import gui.workspace.WorkspaceTree;
import model.workspace.MPNode;
import model.workspace.Workspace;
import model.workspace.WorkspaceModel;

public class MainFrame extends JFrame {
	private static MainFrame instance = null;
	
	private MainMenu menu;
	private WorkspaceModel wsm;
	private WorkspaceTree wst;
	
	private WorkspaceTabbedMenu wtb;
	private MainFrame() {
		setTitle("GeRuDok");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(new Dimension(screenSize.width/2, screenSize.height/2));
		
		menu = new MainMenu();
		setJMenuBar(menu);
		
		MainToolbar toolbar = new MainToolbar();
		add(toolbar, BorderLayout.NORTH);
		
		wsm=new WorkspaceModel(new Workspace());
		wst=new WorkspaceTree((MPNode)wsm.getRoot());
		wst.setModel(wsm);
		
		JScrollPane treePanel=new JScrollPane(wst);
		
		wtb = new WorkspaceTabbedMenu();
		add(wtb, BorderLayout.CENTER);
		
		JSplitPane podela=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePanel, wtb);
		add(podela, BorderLayout.CENTER);
		podela.setDividerLocation(screenSize.width/16);
		
		SwingUtilities.updateComponentTreeUI(this);
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
	
	public WorkspaceTabbedMenu getWorkspaceTabbedMenu() {
		return wtb;
	}
	
}
