package designmode.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import document.model.Slot;
import document.view.MainPageDrawer;

public class RotateState extends State {
	private Slot selectedSlot;
	private Point2D start;

	public RotateState(MainPageDrawer pageView) {
		super(pageView);
	}
	
	public void setSlot(Slot selectedSlot, Point2D start) {
		this.selectedSlot=selectedSlot;
		this.start=start;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point2D end = e.getPoint();
		double slotCenterX=selectedSlot.getSize().getWidth()/2+selectedSlot.getPosition().getX();
		double slotCenterY=selectedSlot.getSize().getHeight()/2+selectedSlot.getPosition().getY();
		Point2D slotCenter=new Point2D.Double(slotCenterX, slotCenterY);
		double k1=(start.getY()-slotCenter.getY())/(start.getX()-slotCenter.getX());
		double k2=(end.getY()-slotCenter.getY())/(end.getX()-slotCenter.getX());
		double tg=(k2-k1)/(1+k1*k2);
		double angle=Math.atan(tg);
		selectedSlot.setAngle(angle);
	}

	public void mouseReleased(MouseEvent e) {
		pageView.getStateManager().setSelectState();
	}
}
