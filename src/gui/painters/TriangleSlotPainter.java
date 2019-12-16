package gui.painters;

import java.awt.geom.GeneralPath;

import model.document.Slot;
import model.document.TriangleSlot;

public class TriangleSlotPainter extends SlotPainter {
	public TriangleSlotPainter(Slot slot) {
		TriangleSlot triangle=(TriangleSlot)slot;
		recalcShape(triangle);
	}
	
	public void recalcShape(Slot slot) {
		shape=new GeneralPath();
		((GeneralPath)shape).moveTo(slot.getPosition().getX(),slot.getPosition().getY());
		//((GeneralPath)shape).lineTo(slot.getPosition().getX()+slot.getSize().width,slot.getPosition().getY());
		((GeneralPath)shape).lineTo(slot.getPosition().getX()+slot.getSize().width,slot.getPosition().getY()+slot.getSize().height);
		((GeneralPath)shape).lineTo(slot.getPosition().getX(),slot.getPosition().getY()+slot.getSize().height);
		((GeneralPath)shape).closePath();
	}
}
