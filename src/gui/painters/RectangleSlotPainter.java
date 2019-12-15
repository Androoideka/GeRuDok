package gui.painters;

import java.awt.geom.GeneralPath;

import model.document.RectangleSlot;
import model.document.Slot;

public class RectangleSlotPainter extends SlotPainter {

	public RectangleSlotPainter(Slot slot) {
		RectangleSlot rectangle = (RectangleSlot) slot;

		shape=new GeneralPath();
		((GeneralPath)shape).moveTo(rectangle.getPosition().x,rectangle.getPosition().y);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y+rectangle.getSize().height);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x,rectangle.getPosition().y+rectangle.getSize().height);
		
		((GeneralPath)shape).closePath();
	}
}
