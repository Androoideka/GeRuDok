package document.model;

import java.awt.geom.GeneralPath;

public class RectangleSlotPainter extends SlotPainter {

	public RectangleSlotPainter(Slot slot) {
		RectangleSlot rectangle = (RectangleSlot) slot;

		recalcShape(rectangle);
	}
	
	public void recalcShape(Slot slot) {
		shape=new GeneralPath();
		((GeneralPath)shape).moveTo(slot.getPosition().getX(),slot.getPosition().getY());
		
		((GeneralPath)shape).lineTo(slot.getPosition().getX()+slot.getSize().width,slot.getPosition().getY());
		
		((GeneralPath)shape).lineTo(slot.getPosition().getX()+slot.getSize().width,slot.getPosition().getY()+slot.getSize().height);
		
		((GeneralPath)shape).lineTo(slot.getPosition().getX(),slot.getPosition().getY()+slot.getSize().height);
		
		((GeneralPath)shape).closePath();
	}
}
