package designmode.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import designmode.controller.RescaleSlotCommand;
import document.model.Slot;
import document.view.MainPageView;
import helpers.UserSpaceScaler;

public class RescaleState extends State {
	private Point2D start;
	private Handle selectedHandle;
	private RescaleSlotCommand command=null;

	public RescaleState(MainPageView pageView) {
		super(pageView);
	}
	
	public void setPoint(Point2D start) {
		this.start=start;
		selectedHandle = pageView.getSelectionModel().getHandleForPoint(start);
	}
	
	public void mouseDragged(MouseEvent e) {
		Point2D end = e.getPoint();
		
		end = UserSpaceScaler.getInstance().toUserSpace(end, pageView.getSize());
		
		double distanceX = end.getX() - start.getX();
		double distanceY = end.getY() - start.getY();
		
		for(Slot slot : pageView.getSelectionModel().getSlots()) {
			if(command==null) {
				command=new RescaleSlotCommand(slot, selectedHandle, distanceX, distanceY);
				pageView.getCommandManager().addCommand(command);
			}else {
				command.setSlot(slot);
				command.setSelectedHandle(selectedHandle);
				command.setDistanceX(distanceX);
				command.setDistanceY(distanceY);
				command.doCommand();
			}
		}
		
		start=end;
	}

	public void mouseReleased(MouseEvent e) {
		pageView.getStateManager().setSelectState();
	}
}
