package state;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import model.document.Page;
import model.document.Slot;
import model.workspace.Document;

public class RotateState extends State {
	private Slot selectedSlot;
	private Point2D start;

	public RotateState(Document doc) {
		super(doc);
	}
	
	public void setSlot(Slot selectedSlot, Point2D start) {
		this.selectedSlot=selectedSlot;
		this.start=start;
	}
	
	public void mouseDragged(MouseEvent e, Page p) {
		Point2D end = e.getPoint();
		double slotCenterX=selectedSlot.getSize().getWidth()/2+selectedSlot.getPosition().getX();
		double slotCenterY=selectedSlot.getSize().getHeight()/2+selectedSlot.getPosition().getY();
		Point2D slotCenter=new Point2D.Double(slotCenterX, slotCenterY);
		double k1=(start.getY()-slotCenter.getY())/(start.getX()-slotCenter.getX());
		double k2=(end.getY()-slotCenter.getY())/(end.getX()-slotCenter.getX());
		double tg=(k1-k2)/(1+k1*k2);
		double angle=Math.atan(tg);
		System.out.println(k1);
		System.out.println(k2);
		System.out.println(tg);
		System.out.println(angle);
		//selectedSlot.rotate(angle);
		selectedSlot.setAngle(angle);
		//start=end;
	}

	public void mouseReleased(MouseEvent e, Page p) {
		doc.getStateManager().setSelectState();
	}
}
