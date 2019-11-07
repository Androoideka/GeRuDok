package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class AboutDialog extends JDialog {	
	public AboutDialog(MainFrame frame) {
		super(frame, "About");
		
		JPanel gornjiPanel=new JPanel(new GridLayout(0, 2));
		gornjiPanel.setPreferredSize(new Dimension(600, 50));
	
		Dimension dim=new Dimension(200, 20);
		
		JLabel menadzer=new JLabel("Stefan Budimac RN06-2018");
		JLabel vodja=new JLabel("Andrej Gasic RN02-2018");
		
		menadzer.setFont(new Font("Verdana", Font.BOLD, 14));
		vodja.setFont(new Font("Verdana", Font.BOLD, 14));
		
		menadzer.setPreferredSize(dim);
		vodja.setPreferredSize(dim);
		
		menadzer.setHorizontalAlignment(JLabel.CENTER);
		vodja.setHorizontalAlignment(JLabel.CENTER);
		
		gornjiPanel.add(vodja);
		gornjiPanel.add(menadzer);
		
		add(gornjiPanel, BorderLayout.NORTH);
		
		JPanel centralniPanel=new JPanel(new GridLayout(4, 2));
		centralniPanel.setPreferredSize(new Dimension(600, 150));
		
		JLabel vodjaEmail=new JLabel("E-mail vodje:");
		JLabel emailVodja=new JLabel("agasic218rn@raf.rs");
		JLabel telefonVodja=new JLabel("Broj telefona vodje:");
		JLabel brTelefonaVodja=new JLabel("+381628931552");
		
		JLabel menadzerEmail=new JLabel("E-mail menadzera:");
		JLabel emailMenadzer=new JLabel("sbudimac618rn@raf.rs");
		JLabel telefonMenadzer=new JLabel("Broj telefona menadzera:");
		JLabel brTelefonaMenadzer=new JLabel("+381653552359");
		
		vodjaEmail.setHorizontalAlignment(JLabel.CENTER);
		emailVodja.setHorizontalAlignment(JLabel.CENTER);
		telefonVodja.setHorizontalAlignment(JLabel.CENTER);
		brTelefonaVodja.setHorizontalAlignment(JLabel.CENTER);
		
		menadzerEmail.setHorizontalAlignment(JLabel.CENTER);
		emailMenadzer.setHorizontalAlignment(JLabel.CENTER);
		telefonMenadzer.setHorizontalAlignment(JLabel.CENTER);
		brTelefonaMenadzer.setHorizontalAlignment(JLabel.CENTER);
		
		vodjaEmail.setVerticalAlignment(JLabel.BOTTOM);
		emailVodja.setVerticalAlignment(JLabel.TOP);
		telefonVodja.setVerticalAlignment(JLabel.BOTTOM);
		brTelefonaVodja.setVerticalAlignment(JLabel.TOP);
		
		menadzerEmail.setVerticalAlignment(JLabel.BOTTOM);
		emailMenadzer.setVerticalAlignment(JLabel.TOP);
		telefonMenadzer.setVerticalAlignment(JLabel.BOTTOM);
		brTelefonaMenadzer.setVerticalAlignment(JLabel.TOP);
		
		vodjaEmail.setPreferredSize(dim);
		emailVodja.setPreferredSize(dim);
		telefonVodja.setPreferredSize(dim);
		brTelefonaVodja.setPreferredSize(dim);
		
		menadzerEmail.setPreferredSize(dim);
		emailMenadzer.setPreferredSize(dim);
		telefonMenadzer.setPreferredSize(dim);
		brTelefonaMenadzer.setPreferredSize(dim);
		
		centralniPanel.add(vodjaEmail);
		centralniPanel.add(menadzerEmail);
		
		centralniPanel.add(emailVodja);
		centralniPanel.add(emailMenadzer);
		
		centralniPanel.add(telefonVodja);
		centralniPanel.add(telefonMenadzer);
		
		centralniPanel.add(brTelefonaVodja);
		centralniPanel.add(brTelefonaMenadzer);
		
		JPanel donjiPanel=new JPanel();
		donjiPanel.setPreferredSize(new Dimension(600, 300));
		
		JLabel timskaSlika = new JLabel(new ImageIcon("tim/tim_201_14.PNG"));
		add(timskaSlika);
		
		donjiPanel.add(timskaSlika);
		
		add(donjiPanel, BorderLayout.SOUTH);
		
		add(centralniPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
