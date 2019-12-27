package document.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import document.view.DocumentView;
import document.view.MainPageView;
import document.view.MiniPageView;
import view.MainFrame;

public class PageSelectionListener extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		if(e.getSource() instanceof MiniPageView) {
			MiniPageView pageView = (MiniPageView)e.getSource();
			
			DocumentView docView = MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView();
			if(docView != null) {
				MainPageView mainPageView = docView.getCurrentView();
				if(mainPageView != null) {
					mainPageView.setPage(pageView.getPage());
				}
			}
		}
	}

}
