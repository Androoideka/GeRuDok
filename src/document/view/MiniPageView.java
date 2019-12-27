package document.view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import document.model.Page;
import document.model.Slot;
import document.model.SlotPainter;
import helpers.UserSpaceScaler;

public class MiniPageView extends PageView {
	
	public MiniPageView(Page page) {
		super(page);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		//this.setPreferredSize(new Dimension(0, 256));
		this.setBackground(Color.WHITE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.scale(this.getSize().getWidth() / UserSpaceScaler.defaultResX, this.getSize().getHeight() / UserSpaceScaler.defaultResY);
		for(Slot slot : page.getSlots()) {
			SlotPainter painter = slot.getSlotPainter();
			painter.paint(g2, slot);
		}
	}
}
