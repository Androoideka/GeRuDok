package document.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;

import designmode.view.Palette;
import observer.IViewObserver;
import observer.ObserverNotification;
import workspace.model.Document;
import workspace.model.DocumentContents;

public class DocumentView extends JSplitPane implements IViewObserver {
	private Document d;
	private JPanel rightPanel;
	private JScrollPane pageScroller;
	private MainPageView mainPageView;
	
	public DocumentView(Document d) {		
		super(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(new PageSlider(d)), new JPanel());
		
		mainPageView = new MainPageView(null);
		
		pageScroller = (JScrollPane)this.getLeftComponent();
		rightPanel = (JPanel)this.getRightComponent();
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(new Palette(), BorderLayout.EAST);
		rightPanel.add(mainPageView);
		
		pageScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pageScroller.getVerticalScrollBar().setUnitIncrement(16);
		
		this.d = d;
		d.addObserver(this);
		setName(d.toString());
	}
	
	public MainPageView getCurrentView() {
		return mainPageView;
	}
	
	public Document getDocument() {
		return d;
	}
	
	@Override
	public void update(ObserverNotification event) {
		if(event.getModelObserver() instanceof Document) {
			setName(d.toString());
		}
		else if(event.getModelObserver() instanceof DocumentContents) {
			mainPageView.setPage(null);
			mainPageView.repaint();
		}
	}
}
