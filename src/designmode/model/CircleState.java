package designmode.model;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import designmode.controller.AddSlotCommand;
import document.model.CircleSlot;
import document.model.Slot;
import document.view.MainPageView;
import helpers.UserSpaceScaler;

public class CircleState extends State {
	private Point2D center;
	private Point2D end;
	private Slot newSlot;
	
	public CircleState(MainPageView pageView) {
		super(pageView);
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			center=e.getPoint();
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		end=e.getPoint();
		
		Point2D realStart = (Point2D)center.clone();
				
		double distance = Math.max(Math.abs(center.getX() - end.getX()),
				Math.abs(center.getY() - end.getY()));
		
		realStart.setLocation(center.getX() - distance, 
				center.getY() - distance);
		
		Point2D realCenter = UserSpaceScaler.getInstance().toUserSpace(center, pageView.getSize());
		realStart = UserSpaceScaler.getInstance().toUserSpace(realStart, pageView.getSize());
		end = UserSpaceScaler.getInstance().toUserSpace(end, pageView.getSize());
		distance = Math.max(Math.abs(realCenter.getX() - end.getX()),
				Math.abs(realCenter.getY() - end.getY()));
		
		Dimension size=new Dimension();
		size.setSize(distance * 2, distance * 2);
		
		if(newSlot == null) {			
			newSlot = new CircleSlot(realStart, size);
			pageView.getCommandManager().addCommand(new AddSlotCommand(pageView, newSlot));
		}
		else {
			newSlot.setPosition(realStart);
			newSlot.setSize(size);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		newSlot=null;
	}
}
