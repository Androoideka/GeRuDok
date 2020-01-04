package designmode.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import designmode.controller.RotateSlotCommand;
import document.model.Slot;
import document.view.MainPageView;
import helpers.UserSpaceScaler;

public class RotateState extends State {
	private Point2D start;
	private RotateSlotCommand command=null;

	public RotateState(MainPageView pageView) {
		super(pageView);
	}
	
	public void setPoint(Point2D start) {
		this.start=start;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point2D end = e.getPoint();
		
		end = UserSpaceScaler.getInstance().toUserSpace(end, pageView.getSize());
		
		//uzmi poslednji slot i rotiraj po njegovom uglu
		int last = pageView.getSelectionModel().getNumberOfSlots() - 1;
		Slot s = pageView.getSelectionModel().getSlots().get(last);
		
		double slotCenterX=s.getSize().getWidth()/2+s.getPosition().getX();
		double slotCenterY=s.getSize().getHeight()/2+s.getPosition().getY();
		Point2D slotCenter=new Point2D.Double(slotCenterX, slotCenterY);
		double k1=(start.getY()-slotCenter.getY())/(start.getX()-slotCenter.getX());
		double k2=(end.getY()-slotCenter.getY())/(end.getX()-slotCenter.getX());
		double tg=(k2-k1)/(1+k1*k2);
		double angle=Math.atan(tg);
		
		for(Slot slot : pageView.getSelectionModel().getSlots()) {
			if(command==null) {
				command=new RotateSlotCommand(slot, angle);
				pageView.getCommandManager().addCommand(command);
			}else {
				command.setSlot(slot);
				command.setAngle(angle);
				command.doCommand();
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		pageView.getStateManager().setSelectState();
	}
}
