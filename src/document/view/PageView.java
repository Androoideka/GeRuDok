package document.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.UIManager;

import document.model.Page;
import document.model.Slot;
import document.model.SlotPainter;
import helpers.UserSpaceScaler;
import observer.IViewObserver;
import observer.ObserverEventType;
import observer.ObserverNotification;

public abstract class PageView extends JPanel implements IViewObserver {
	protected Page page;

	public PageView(Page page) {
		super();
		
		setPage(page);
	}
	
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		if(this.page == page) {
			return;
		}
		
		if(this.page != null) {
			this.page.removeObserver(this);
		}
		
		this.page = page;
		if(page != null) {
			page.addObserver(this);
			for(Slot slot : page.getSlots()) {
				slot.addObserver(this);
			}
			setName(page.toString());
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(page == null) {
			this.setBackground(UIManager.getColor ( "Panel.background" ));
			return;
		}
		this.setBackground(Color.WHITE);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.scale(this.getSize().getWidth() / UserSpaceScaler.defaultResX, this.getSize().getHeight() / UserSpaceScaler.defaultResY);
		for(Slot slot : page.getSlots()) {
			SlotPainter painter = slot.getSlotPainter();
			painter.paint(g2, slot);
		}
	}
	
	@Override
	public void update(ObserverNotification event) {
		if(event.getEventType() == ObserverEventType.ADD) {
			event.getModelObserver().addObserver(this);
		}
		repaint();
	}
}
