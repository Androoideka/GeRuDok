package document.view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import designmode.controller.NewPageAction;
import document.controller.PageSelectionListener;
import document.model.Page;
import observer.IViewObserver;
import observer.ObserverNotification;
import workspace.model.Document;

public class PageSlider extends JPanel implements IViewObserver {
	
	private Document d;
	private List<MiniPageView> pageViews = new ArrayList<>();
	private JPanel newPage;
	private PageSelectionListener selectionListener = new PageSelectionListener();

	public PageSlider(Document d) {
		super();
		
		setLayout(new GridLayout(0, 1, 0, 20));
		
		this.d = d;
		d.addObserver(this);
		setName(d.getName());
		
		JButton newPageButton = new JButton("Add");
		newPageButton.addActionListener(new NewPageAction(this));
		newPage = new JPanel();
		newPage.add(newPageButton);
		this.add(newPage);
		
		for(Page p : d.getPages()) {
			createNewPage(p);
		}
	}
	
	public void createNewPage(Page p) {
		this.remove(newPage);
		d.addPage(p);
		
		MiniPageView pageView = new MiniPageView(p);
		pageView.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		//pageView.setPreferredSize(new Dimension(0, 120));
		pageView.addMouseListener(selectionListener);
		
		pageViews.add(pageView);
		
		this.add(pageView);
		this.add(newPage);
	}
	
	public Document getDocument() {
		return d;
	}
	
	@Override
	public void update(ObserverNotification event) {
		setName(d.getName());
	}
}
