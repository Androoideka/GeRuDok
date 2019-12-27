package designmode.model;

import java.awt.event.MouseEvent;

import document.view.MainPageView;

public abstract class State {
	protected MainPageView pageView;
	
	public State(MainPageView pageView) {
		this.pageView = pageView;
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseDragged(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseMoved(MouseEvent e) {
		
	}
}
