package state;

import java.awt.event.MouseEvent;

import model.document.Page;
import model.workspace.Document;

public abstract class State {
	protected Document mediator;
	
	public State(Document mediator) {
		this.mediator = mediator;
	}
	
	public void mousePressed(MouseEvent e, Page p) {
		
	}
	public void mouseDragged(MouseEvent e, Page p) {
		
	}
	public void mouseReleased(MouseEvent e, Page p) {
		
	}
	public void mouseMoved(MouseEvent e, Page p) {
		
	}
}
