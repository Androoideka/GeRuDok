package document.view;

import java.awt.BorderLayout;

import designmode.view.Palette;
import document.model.Page;

public class MainPageView extends PageView {
	private MainPageDrawer pageDrawer;
	
	public MainPageView(Page page) {
		super(page);
		
		setLayout(new BorderLayout());
		
		Palette palette = new Palette();
		this.add(palette, BorderLayout.EAST);
		
		pageDrawer = new MainPageDrawer(page);
		this.add(pageDrawer, BorderLayout.CENTER);
	}
	
	public MainPageDrawer getPageDrawer() {
		return pageDrawer;
	}
	
	@Override
	public void setPage(Page page) {
		super.setPage(page);
		if(pageDrawer != null) {
			pageDrawer.setPage(page);
			pageDrawer.repaint();
		}
	}
}
