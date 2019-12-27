package designmode.model;

import java.awt.event.MouseEvent;

import java.awt.geom.Point2D;

import document.model.Slot;
import document.view.MainPageDrawer;

public class GrabState extends State {
	private Slot selectedSlot;
	private Point2D start;

	public GrabState(MainPageDrawer pageView) {
		super(pageView);
	}

	public void setSlot(Slot selectedSlot, Point2D start) {
		this.selectedSlot=selectedSlot;
		this.start=start;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point2D end = e.getPoint();
		double distanceX = end.getX() - start.getX();
		double distanceY = end.getY() - start.getY();
		Point2D position = (Point2D) selectedSlot.getPosition().clone();
		position.setLocation(position.getX() + distanceX, position.getY() + distanceY);
		selectedSlot.setPosition(position);
		start = end;
	}

	public void mouseReleased(MouseEvent e) {
		pageView.getStateManager().setSelectState();
	}
}
