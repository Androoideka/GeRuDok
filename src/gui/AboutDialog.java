package gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog {	
	public AboutDialog(MainFrame frame) {
		super(frame, "About");
		Dimension dim=new Dimension(30, 20);
		JLabel manager=new JLabel("Stefan Budimac RN06-2018");
		JLabel leader=new JLabel("Andrej Gasic RN02-2018");
		JLabel indexManager=new JLabel("RN06-2018");
		JLabel indexLeader=new JLabel("RN02-2018");
		manager.setSize(dim);
		leader.setSize(dim);
		indexManager.setSize(dim);
		indexLeader.setSize(dim);
		GridLayout layout=new GridLayout(2, 2);
		JPanel panel=new JPanel(layout);
		panel.add(manager);
		panel.add(leader);
		panel.add(indexManager);
		panel.add(indexLeader);
		add(panel);
		setSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
