package document.view;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;

import observer.IViewObserver;
import observer.ObserverNotification;
import workspace.model.Document;

public class DocumentView extends JSplitPane implements IViewObserver {//extends JPanel implements IViewObserver {
	private Document d;
	//private JPanel leftPanel;
	private JScrollPane pageScroller;
	private MainPageView mainPageView;
	
	public DocumentView(Document d) {
		super(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(new PageSlider(d)), new MainPageView(null));
		
		pageScroller = (JScrollPane)this.getLeftComponent();
		mainPageView = (MainPageView)this.getRightComponent();
		
		pageScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pageScroller.getVerticalScrollBar().setUnitIncrement(16);
		
		this.d = d;
		d.addObserver(this);
		setName(d.getName());
	}
	
	public MainPageView getCurrentView() {
		return mainPageView;
	}
	
	public Document getDocument() {
		return d;
	}
	
	@Override
	public void update(ObserverNotification event) {
		setName(d.getName());
	}
}
