package document.view;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import document.model.Page;

public class MiniPageView extends PageView {
	
	public MiniPageView(Page page) {
		super(page);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}
}
