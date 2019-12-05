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
		setName(d.getName());
		p = new JLabel(d.getName());
		add(p, BorderLayout.NORTH);
	}
	
	public Document getDocument() {
		return d;
	}
	
	@Override
	public void update(Object event) {
		setName(d.getName());
		p.setText(d.getName());
	}
}
