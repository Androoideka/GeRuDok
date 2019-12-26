package designmode.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import document.model.Page;
import document.model.Slot;
import workspace.model.Document;

public class RescaleState extends State {
	private Slot selectedSlot;
	private Point2D start;
	private Handle selectedHandle;

	public RescaleState(Document doc) {
		super(doc);
	}
	
	public void setSlot(Slot selectedSlot, Point2D start) {
		this.selectedSlot=selectedSlot;
		this.start=start;
		selectedHandle = selectedSlot.getHandleForPoint(start);
	}
	
	public void mouseDragged(MouseEvent e, Page p) {
		Point2D end = e.getPoint();
		double distanceX = end.getX() - start.getX();
		double distanceY = end.getY() - start.getY();
		selectedSlot.scale(selectedHandle, distanceX, distanceY);
		start=end;
	}

	public void mouseReleased(MouseEvent e, Page p) {
		doc.getStateManager().setSelectState();
	}
}
