package designmode.model;

import java.awt.event.MouseEvent;

import document.view.MainPageDrawer;

public abstract class State {
	protected MainPageDrawer pageView;
	
	public State(MainPageDrawer pageView) {
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
