package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog {	
	public AboutDialog(MainFrame frame) {
		super(frame, "About");
		
		JPanel gornjiPanel=new JPanel(new FlowLayout());
		gornjiPanel.setPreferredSize(new Dimension(600, 50));
	
		Dimension dim=new Dimension(50, 20);
		JLabel menadzer=new JLabel("Stefan Budimac RN06-2018");
		JLabel vodja=new JLabel("Andrej Gasic RN02-2018");
		menadzer.setPreferredSize(dim);
		vodja.setPreferredSize(dim);
		
		gornjiPanel.add(menadzer);
		gornjiPanel.add(vodja);
		
		add(gornjiPanel, BorderLayout.NORTH);
		
		JPanel centralniPanel=new JPanel(new GridLayout(2, 2, 0, 10));
		centralniPanel.setPreferredSize(new Dimension(600, 250));
		
		JLabel emailMenadzer=new JLabel("sbudimac618rn@raf.rs");
		JLabel brTelefonaMenadzer=new JLabel("+381653552359");
		JLabel emailVodja=new JLabel("agasic218rn@raf.rs");
		JLabel brTelefonaVodja=new JLabel("+381628931552");
		emailMenadzer.setPreferredSize(dim);
		brTelefonaMenadzer.setPreferredSize(dim);
		emailVodja.setPreferredSize(dim);
		brTelefonaVodja.setPreferredSize(dim);
		centralniPanel.add(emailMenadzer, 0, 0);
		centralniPanel.add(brTelefonaMenadzer, 1, 0);
		centralniPanel.add(emailVodja, 0, 1);
		centralniPanel.add(brTelefonaVodja, 1, 1);
		
		add(centralniPanel, BorderLayout.CENTER);
		
		JPanel donjiPanel=new JPanel();
		
		JLabel timskaSlika = new JLabel(new ImageIcon("tim/tim_201_14.PNG"));
		add(timskaSlika);
		
		donjiPanel.add(timskaSlika);
		
		add(donjiPanel, BorderLayout.SOUTH);
		
		setSize(new Dimension(600, 500));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
