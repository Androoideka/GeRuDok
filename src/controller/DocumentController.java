package controller;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import gui.PageView;
import model.document.Page;
import model.workspace.Document;

public class DocumentController extends MouseAdapter implements MouseMotionListener {

	private Document d;
	
	public DocumentController(Document d) {
		this.d = d;
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getSource() instanceof PageView) {
			PageView pageView = (PageView)e.getSource();
			Page p = pageView.getPage();
			d.getStateManager().getCurrentState().mousePressed(e, p);
		}
	}
	public void mouseDragged(MouseEvent e) {
		if(e.getSource() instanceof PageView) {
			PageView pageView = (PageView)e.getSource();
			Page p = pageView.getPage();
			d.getStateManager().getCurrentState().mouseDragged(e, p);
		}
	}
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() instanceof PageView) {
			PageView pageView = (PageView)e.getSource();
			Page p = pageView.getPage();
			d.getStateManager().getCurrentState().mouseReleased(e, p);
		}
	}
	public void mouseMoved(MouseEvent e) {
		if(e.getSource() instanceof PageView) {
			PageView pageView = (PageView)e.getSource();
			Page p = pageView.getPage();
			d.getStateManager().getCurrentState().mouseMoved(e, p);
		}
	}
}
