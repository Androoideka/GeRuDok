package document.view;

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

import designmode.controller.DocumentController;
import designmode.controller.NewPageAction;
import designmode.view.Palette;
import document.model.Page;
import observer.IViewObserver;
import observer.ObserverNotification;
import workspace.model.Document;

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
		
		PageView pageView = new PageView(p, dc);
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
	}
}
