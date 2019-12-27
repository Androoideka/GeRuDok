package designmode.model;

import java.awt.event.MouseEvent;

import java.awt.geom.Point2D;

import document.model.Slot;
import document.view.MainPageView;
import helpers.UserSpaceScaler;

public class GrabState extends State {
	private Point2D start;

	public GrabState(MainPageView pageView) {
		super(pageView);
	}

	public void setPoint(Point2D start) {
		this.start=start;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point2D end = e.getPoint();
		end = UserSpaceScaler.getInstance().toUserSpace(end, pageView.getSize());
		
		double distanceX = end.getX() - start.getX();
		double distanceY = end.getY() - start.getY();
		
		for(Slot slot : pageView.getSelectionModel().getSlots()) {
			Point2D position = (Point2D) slot.getPosition().clone();
			position.setLocation(position.getX() + distanceX, position.getY() + distanceY);
			slot.setPosition(position);
		}
		
		start = end;
	}

	public void mouseReleased(MouseEvent e) {
		pageView.getStateManager().setSelectState();
	}
}
