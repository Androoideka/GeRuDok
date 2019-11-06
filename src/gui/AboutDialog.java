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
	
		Dimension dim=new Dimension(200, 20);
		JLabel menadzer=new JLabel("Stefan Budimac RN06-2018");
		JLabel vodja=new JLabel("Andrej Gasic RN02-2018");
		menadzer.setPreferredSize(dim);
		vodja.setPreferredSize(dim);
		
		gornjiPanel.add(menadzer);
		gornjiPanel.add(vodja);
		
		add(gornjiPanel, BorderLayout.NORTH);
		
		JPanel centralniPanel=new JPanel(new GridLayout(4, 2, 0, 10));
		centralniPanel.setPreferredSize(new Dimension(600, 150));
		
		JLabel menadzerEmail=new JLabel("E-mejl menadzera:");
		JLabel emailMenadzer=new JLabel("sbudimac618rn@raf.rs");
		JLabel telefonMenadzer=new JLabel("Broj telefona menadzera:");
		JLabel brTelefonaMenadzer=new JLabel("+381653552359");
		JLabel vodjaEmail=new JLabel("E-mejl vodje:");
		JLabel emailVodja=new JLabel("agasic218rn@raf.rs");
		JLabel telefonVodja=new JLabel("Broj telefona vodje:");
		JLabel brTelefonaVodja=new JLabel("+381628931552");
		
		menadzerEmail.setPreferredSize(dim);
		emailMenadzer.setPreferredSize(dim);
		telefonMenadzer.setPreferredSize(dim);
		brTelefonaMenadzer.setPreferredSize(dim);
		vodjaEmail.setPreferredSize(dim);
		emailVodja.setPreferredSize(dim);
		telefonVodja.setPreferredSize(dim);
		brTelefonaVodja.setPreferredSize(dim);
		
		centralniPanel.add(menadzerEmail);
		centralniPanel.add(vodjaEmail);
		centralniPanel.add(emailMenadzer);
		centralniPanel.add(emailVodja);
		centralniPanel.add(telefonMenadzer);
		centralniPanel.add(telefonVodja);
		centralniPanel.add(brTelefonaMenadzer);
		centralniPanel.add(brTelefonaVodja);
		
		JPanel donjiPanel=new JPanel();
		donjiPanel.setPreferredSize(new Dimension(600, 300));
		
		JLabel timskaSlika = new JLabel(new ImageIcon("tim/tim_201_14.PNG"));
		add(timskaSlika);
		
		donjiPanel.add(timskaSlika);
		
		add(donjiPanel, BorderLayout.SOUTH);
		
		add(centralniPanel, BorderLayout.CENTER);
		
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
