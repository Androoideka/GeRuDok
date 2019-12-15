package gui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import gui.workspace.WorkspaceTree;

public class MainFrame extends JFrame {
	private static MainFrame instance = null;
	
	private MainMenu menu;
	private WorkspaceTree wst;
	
	private WorkspaceTabbedMenu wtb;
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
		
		JScrollPane treePanel=new JScrollPane(wst);
		
		wtb = new WorkspaceTabbedMenu();
		add(wtb, BorderLayout.CENTER);
		
		JSplitPane podela=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePanel, wtb);
		add(podela, BorderLayout.CENTER);
		podela.setDividerLocation(screenSize.width/16);
		
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
	
	public WorkspaceTabbedMenu getWorkspaceTabbedMenu() {
		return wtb;
	}
	
}
