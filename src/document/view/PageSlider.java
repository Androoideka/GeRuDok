package document.view;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import designmode.controller.NewPageAction;
import document.controller.PageSelectionListener;
import document.model.Page;
import observer.IViewObserver;
import observer.ObserverNotification;
import workspace.model.Document;
import workspace.model.DocumentContents;

public class PageSlider extends JPanel implements IViewObserver {
	
	private Document d;
	private List<MiniPageView> pageViews = new ArrayList<>();
	private JPanel newPage;
	private GridBagConstraints c;
	private PageSelectionListener selectionListener = new PageSelectionListener();

	public PageSlider(Document d) {
		super();
		
		setLayout(new GridBagLayout());
	    c = new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.insets = new Insets(0,10,20,10);
	    c.gridx = 0;
	    c.gridy = 0;
	    
		this.d = d;
		d.addObserver(this);
		setName(d.toString());
		
		refreshContents();
	}
	
	public void createNewPage(Page p) {
		this.remove(newPage);
		d.getContents().addPage(p);
		
		MiniPageView pageView = new MiniPageView(p);
		Dimension size = new Dimension();
		size.setSize(this.getSize().getWidth()-c.insets.left-c.insets.right, 256);
		pageView.setPreferredSize(size);
		pageView.addMouseListener(selectionListener);
		
		pageViews.add(pageView);
		
		this.add(pageView, c);
		c.gridy++;
		this.add(newPage, c);
	}
	
	private void refreshContents() {
		this.removeAll();
		
		JButton newPageButton = new JButton("Add");
		newPageButton.addActionListener(new NewPageAction(this));
		newPage = new JPanel();
		newPage.add(newPageButton);
		this.add(newPage, c);
		
		for(Page p : d.getContents().getPages()) {
			createNewPage(p);
		}
	}
	
	@Override
	public void update(ObserverNotification event) {
		if(event.getModelObserver() instanceof Document) {
			setName(d.toString());
		}
		else if(event.getModelObserver() instanceof DocumentContents) {
			refreshContents();
			revalidate();
			repaint();
		}
	}
}
