package state;

import java.awt.event.MouseEvent;

import model.document.Page;
import model.workspace.Document;

public class SelectState extends State {

	public SelectState(Document mediator) {
		super(mediator);
	}

	public void mousePressed(MouseEvent e, Page p) {
		if (e.getButton()==MouseEvent.BUTTON1) {
			
		}
	}
}
