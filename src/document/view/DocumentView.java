package document.view;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import observer.IViewObserver;
import observer.ObserverNotification;
import workspace.model.Document;

public class DocumentView extends JSplitPane implements IViewObserver {//extends JPanel implements IViewObserver {
	private Document d;
	private JScrollPane pageScroller;
	private MainPageView mainPageView;
	
	public DocumentView(Document d) {
		super(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(new PageSlider(d)), new MainPageView(null));
		
		pageScroller = (JScrollPane)this.getLeftComponent();
		mainPageView = (MainPageView)this.getRightComponent();
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
	
	/*private JPanel pageSlider;
	private JScrollPane scrollSlider;
	private List<MiniPageView> pageViews = new ArrayList<>();
	private JPanel newPage;
	private PageController dc;
	
	public DocumentView(Document d) {
		super();
		this.d = d;
		d.addObserver(this);
		setName(d.getName());
		dc = new PageController(d);
		
		setLayout(new BorderLayout());
		
		Palette palette = new Palette();
		this.add(palette, BorderLayout.EAST);
		
		pageSlider = new JPanel(new GridLayout(0, 1, 0, 20));
		
		JButton newPageButton = new JButton("Add");
		newPageButton.addActionListener(new NewPageAction(this));
		newPage = new JPanel();
		newPage.add(newPageButton);
		
		pageSlider.add(newPage);
		
		for(Page p : d.getPages()) {
			createNewPage(p);
		}
		
		scrollSlider = new JScrollPane(pageSlider);
		scrollSlider.getVerticalScrollBar().setUnitIncrement(16);
		this.add(scrollSlider, BorderLayout.CENTER);
	}
	
	public void createNewPage(Page p) {
		pageSlider.remove(newPage);
		d.addPage(p);
		
		MiniPageView pageView = new MiniPageView(p, dc);
		pageView.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		pageView.setBackground(Color.WHITE);
		pageView.setPreferredSize(new Dimension(0, pageSlider.getSize().width/16*9));
		
		pageSlider.add(pageView);
		pageSlider.add(newPage);
	}
	
	public Document getDocument() {
		return d;
	}
	
	@Override
	public void update(ObserverNotification event) {
		setName(d.getName());
	}*/
}
