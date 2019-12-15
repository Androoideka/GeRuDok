package gui.painters;

import java.awt.geom.GeneralPath;

import model.document.Slot;
import model.document.TriangleSlot;

public class TriangleSlotPainter extends SlotPainter {
	public TriangleSlotPainter(Slot slot) {
		TriangleSlot triangle=(TriangleSlot)slot;
		shape=new GeneralPath();
		((GeneralPath)shape).moveTo(triangle.getPosition().getX(),triangle.getPosition().getY());
		((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getSize().width,triangle.getPosition().getY());
		((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getSize().width,triangle.getPosition().getY()+triangle.getSize().height);
		((GeneralPath)shape).closePath();
	}
}
