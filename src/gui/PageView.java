package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import gui.painters.SlotPainter;
import model.document.Page;
import model.document.Slot;
import observer.IViewObserver;
import observer.ObserverNotification;

public class PageView extends JPanel implements IViewObserver {
	
	private Page p;

	public PageView(Page p) {
		super();
		this.p = p;
		p.addObserver(this);
		setName(p.getName());
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for(Slot slot : p.getSlots()) {
			SlotPainter painter = slot.getSlotPainter();
			painter.paint(g2, slot);
		}
	}

	@Override
	public void update(ObserverNotification event) {
		repaint();
	}
}
