package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.workspace.Document;
import observer.IViewObserver;

public class DocumentView extends JPanel implements IViewObserver {
	private Document d;
	private JLabel p;
	public DocumentView(Document d) {
		super();
		this.d = d;
		d.addObserver(this);
		p = new JLabel(d.getName());
		add(p, BorderLayout.NORTH);
	}
	@Override
	public void update(Object event) {
		p.setText(d.getName());
	}
	
	public Document getDocument() {
		return d;
	}
}
