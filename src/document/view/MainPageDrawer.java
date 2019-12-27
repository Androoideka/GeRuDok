package document.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.UIManager;

import designmode.controller.PageController;
import designmode.model.StateManager;
import document.model.Page;
import document.model.Slot;
import document.model.SlotPainter;

public class MainPageDrawer extends PageView {
	private StateManager stateManager = new StateManager(this);

	public MainPageDrawer(Page page) {
		super(page);
		
		//this.setBackground(Color.WHITE);
		
		PageController pc = new PageController();
		this.addMouseListener(pc);
		this.addMouseMotionListener(pc);
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(page == null) {
			this.setBackground(UIManager.getColor ( "Panel.background" ));
			return;
		}
		this.setBackground(Color.WHITE);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for(Slot slot : page.getSlots()) {
			SlotPainter painter = slot.getSlotPainter();
			painter.paint(g2, slot);
		}
	}
}
