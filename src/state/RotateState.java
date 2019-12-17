package state;

import java.awt.event.MouseEvent;

import model.document.Page;
import model.workspace.Document;

public class RotateState extends State {

	public RotateState(Document doc) {
		super(doc);
	}
	
	public void mouseDragged(MouseEvent e, Page p) {
		if(e.getButton()==MouseEvent.BUTTON2) {
			
		}
	}

	public void mouseReleased(MouseEvent e, Page p) {
		doc.getStateManager().setSelectState();
	}
}
