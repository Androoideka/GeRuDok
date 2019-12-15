package gui.painters;

import java.awt.geom.GeneralPath;

import model.document.RectangleSlot;
import model.document.Slot;

public class RectangleSlotPainter extends SlotPainter {

	public RectangleSlotPainter(Slot slot) {
		RectangleSlot rectangle = (RectangleSlot) slot;

		shape=new GeneralPath();
		((GeneralPath)shape).moveTo(rectangle.getPosition().getX(),rectangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY()+rectangle.getSize().height);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX(),rectangle.getPosition().getY()+rectangle.getSize().height);
		
		((GeneralPath)shape).closePath();
	}
}
