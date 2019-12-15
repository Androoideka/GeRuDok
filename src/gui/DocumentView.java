package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.NewPageAction;
import model.document.Page;
import model.workspace.Document;
import observer.IViewObserver;
import observer.ObserverNotification;

public class DocumentView extends JPanel implements IViewObserver {
	private Document d;
	private JPanel pageSlider;
	private List<PageView> pageViews = new ArrayList<>();
	
	public DocumentView(Document d) {
		super();
		this.d = d;
		d.addObserver(this);
		setName(d.getName());
		
		setLayout(new BorderLayout());
		
		pageSlider = new JPanel(new GridLayout(0, 1, 0, 20));
		
		for(Page p : d.getPages()) {
			createNewPage(p);
		}
		
		this.add(new JScrollPane(pageSlider));
		
		JButton add = new JButton("Add");
        add.addActionListener(new NewPageAction(this));
        
        add(add, BorderLayout.SOUTH);
	}
	
	public void createNewPage(Page p) {
		d.addPage(p);
		
		PageView pageView = new PageView(p);
		pageView.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		pageView.setBackground(Color.WHITE);
		pageView.setPreferredSize(new Dimension(0, this.getSize().width));
		
		pageSlider.add(pageView);
	}
	
	public Document getDocument() {
		return d;
	}
	
	@Override
	public void update(ObserverNotification event) {
		setName(d.getName());
	}
}
