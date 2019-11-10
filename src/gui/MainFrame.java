package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


import model.workspace.Workspace;
import model.workspace.WorkspaceModel;
import workspace.tree.WorkspaceTree;
import workspace.tree.WorkspaceTreeCellRenderer;

public class MainFrame extends JFrame {
	private static MainFrame instance = null;
	
	private MainMenu menu;
	private WorkspaceModel wsm;
	private WorkspaceTree wst;
	
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
		wst=new WorkspaceTree();
		wst.setModel(wsm);
		
		JScrollPane treePanel=new JScrollPane(wst);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		tabbedPane.addTab("Tab 1", p1);
		tabbedPane.addTab("Tab 2", p2);
		add(tabbedPane, BorderLayout.CENTER);
		
		JSplitPane podela=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePanel, tabbedPane);
		add(podela, BorderLayout.CENTER);
		podela.setDividerLocation(screenSize.width/16);
		
		SwingUtilities.updateComponentTreeUI(this);
		
		
		
		
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
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

	public WorkspaceModel getWorkspaceModel() {
		return wsm;
	}
	
	
}
