package designmode.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import document.model.Slot;
import document.view.MainPageDrawer;

public class RescaleState extends State {
	private Slot selectedSlot;
	private Point2D start;
	private Handle selectedHandle;

	public RescaleState(MainPageDrawer pageView) {
		super(pageView);
	}
	
	public void setSlot(Slot selectedSlot, Point2D start) {
		this.selectedSlot=selectedSlot;
		this.start=start;
		selectedHandle = selectedSlot.getHandleForPoint(start);
	}
	
	public void mouseDragged(MouseEvent e) {
		Point2D end = e.getPoint();
		double distanceX = end.getX() - start.getX();
		double distanceY = end.getY() - start.getY();
		selectedSlot.scale(selectedHandle, distanceX, distanceY);
		start=end;
	}

	public void mouseReleased(MouseEvent e) {
		pageView.getStateManager().setSelectState();
	}
}
