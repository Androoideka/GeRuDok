package designmode.controller;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import document.view.MainPageDrawer;

public class PageController extends MouseAdapter implements MouseMotionListener {
	
	public void mousePressed(MouseEvent e) {
		if(e.getSource() instanceof MainPageDrawer) {
			MainPageDrawer pageView = (MainPageDrawer)e.getSource();
			if(pageView.getPage() == null) {
				return;
			}
			pageView.getStateManager().getCurrentState().mousePressed(e);
		}
	}
	public void mouseDragged(MouseEvent e) {
		if(e.getSource() instanceof MainPageDrawer) {
			MainPageDrawer pageView = (MainPageDrawer)e.getSource();
			if(pageView.getPage() == null) {
				return;
			}
			pageView.getStateManager().getCurrentState().mouseDragged(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() instanceof MainPageDrawer) {
			MainPageDrawer pageView = (MainPageDrawer)e.getSource();
			if(pageView.getPage() == null) {
				return;
			}
			pageView.getStateManager().getCurrentState().mouseReleased(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
		if(e.getSource() instanceof MainPageDrawer) {
			MainPageDrawer pageView = (MainPageDrawer)e.getSource();
			if(pageView.getPage() == null) {
				return;
			}
			pageView.getStateManager().getCurrentState().mouseMoved(e);
		}
	}
}
