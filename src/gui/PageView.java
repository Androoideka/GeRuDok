package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import controller.DocumentController;
import gui.painters.SlotPainter;
import model.document.Page;
import model.document.Slot;
import observer.IViewObserver;
import observer.ObserverEventType;
import observer.ObserverNotification;

public class PageView extends JPanel implements IViewObserver {
	
	private Page p;

	public PageView(Page p, DocumentController dc) {
		super();
		this.p = p;
		p.addObserver(this);
		setName(p.getName());
		
		this.addMouseListener(dc);
		this.addMouseMotionListener(dc);
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

	public Page getPage() {
		return p;
	}

	@Override
	public void update(ObserverNotification event) {
		if(event.getEventType() == ObserverEventType.ADD) {
			event.getModelObserver().addObserver(this);
		}
		repaint();
	}
}
