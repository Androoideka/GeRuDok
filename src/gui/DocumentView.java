package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

import controller.NewPageAction;
import controller.DocumentController;
import model.document.Page;
import model.workspace.Document;
import observer.IViewObserver;
import observer.ObserverNotification;

public class DocumentView extends JPanel implements IViewObserver {
	private Document d;
	private JPanel pageSlider;
	private JScrollPane scrollSlider;
	private List<PageView> pageViews = new ArrayList<>();
	private JPanel newPage;
	private DocumentController dc;
	
	public DocumentView(Document d) {
		super();
		this.d = d;
		d.addObserver(this);
		setName(d.getName());
		dc = new DocumentController(d);
		
		setLayout(new BorderLayout());
		
		Palette palette = new Palette();
		this.add(palette, BorderLayout.EAST);
		
		pageSlider = new JPanel(new GridLayout(0, 1, 0, 20));
		
		for(Page p : d.getPages()) {
			createNewPage(p);
		}
		
		JButton newPageButton = new JButton("Add");
		newPageButton.addActionListener(new NewPageAction(this));
		newPage = new JPanel();
		newPage.add(newPageButton);
		
		pageSlider.add(newPage);
		
		scrollSlider = new JScrollPane(pageSlider);
		this.add(scrollSlider, BorderLayout.CENTER);
	}
	
	public void createNewPage(Page p) {
		pageSlider.remove(newPage);
		d.addPage(p);
		
		PageView pageView = new PageView(p, dc);
		pageView.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		pageView.setBackground(Color.WHITE);
		pageView.setPreferredSize(new Dimension(0, this.getSize().width/16*9));
		
		pageSlider.add(pageView);
		pageSlider.add(newPage);
	}
	
	public Document getDocument() {
		return d;
	}
	
	/*public PageView getCurrentView() {
		JViewport viewport = scrollSlider.getViewport();
		
		Point2D topLeft = viewport.getViewPosition();
		Dimension viewRect = viewport.getExtentSize();
		Point2D center = (Point2D)topLeft.clone();
		center.setLocation(topLeft.getX() + viewRect.width/2, topLeft.getY() + viewRect.height/2);
		
		Component current = pageSlider.getComponentAt((Point)center);
		if(current != null && current != pageSlider) {
			PageView pageView = (PageView)current;
			return pageView;
		}
		return null;
	}*/
	
	@Override
	public void update(ObserverNotification event) {
		setName(d.getName());
	}
}
