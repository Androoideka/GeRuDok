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
import observer.ObserverEventType;
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
		d.getContents().addObserver(this);
		
		setName(d.toString());
		
		JButton newPageButton = new JButton("Add");
		newPageButton.addActionListener(new NewPageAction(this));
		newPage = new JPanel();
		newPage.add(newPageButton);
		
		refreshContents();
	}
	
	public MiniPageView createNewPage(Page p) {
		d.getContents().addPage(p);
		
		MiniPageView pageView = new MiniPageView(p);
		Dimension size = new Dimension();
		size.setSize(this.getSize().getWidth()-c.insets.left-c.insets.right, 256);
		pageView.setPreferredSize(size);
		pageView.addMouseListener(selectionListener);
		
		return pageView;
	}
	
	private void refreshContents() {
		this.removeAll();
		
		c.gridy = 0;
		
		for(int i = 0; i < d.getContents().getNumberOfPages(); i++) {
			Page p = d.getContents().getPages().get(i);
			if(pageViews.size() < i+1 || pageViews.get(i).getPage() != p) {
				pageViews.add(i, createNewPage(p));
			}
		}
		
		for(MiniPageView pv : pageViews) {
			this.add(pv, c);
			c.gridy++;
		}
		
		this.add(newPage, c);
	}
	
	@Override
	public void update(ObserverNotification event) {
		if(event.getModelObserver() instanceof Document) {
			setName(d.toString());
		}
		else {
			if(event.getEventType() == ObserverEventType.REMOVE && event.getModelObserver() instanceof DocumentContents) {
				event.getModelObserver().removeObserver(this);
				d.getContents().addObserver(this);
				pageViews.clear();
			}
			refreshContents();
			revalidate();
			repaint();
		}
	}
}
