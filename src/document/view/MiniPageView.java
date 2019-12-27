package document.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import document.model.Page;
import document.model.Slot;
import document.model.SlotPainter;

public class MiniPageView extends PageView {
	
	public MiniPageView(Page page) {
		super(page);
		
		this.setBackground(Color.WHITE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for(Slot slot : page.getSlots()) {
			SlotPainter painter = slot.getSlotPainter();
			painter.paint(g2, slot);
		}
	}
	/*private Page p;

	public MiniPageView(Page p, DocumentController dc) {
		super();
		this.p = p;
		p.addObserver(this);
		for(Slot slot : p.getSlots()) {
			slot.addObserver(this);
		}
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
	}*/
}
