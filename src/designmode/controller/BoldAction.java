package designmode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import designmode.view.SelectedText;
import helpers.ImageResizer;
import view.MainFrame;

public class BoldAction extends AbstractAction {
	private StyledDocument document;
	private JTextPane tp;
	
	public BoldAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ImageResizer.getInstance().loadSmallIcon("ikonice/bold.png"));
		putValue(LARGE_ICON_KEY, ImageResizer.getInstance().loadBigIcon("ikonice/bold.png"));
		putValue(NAME, "Bold");
		putValue(SHORT_DESCRIPTION, "Bold selected text.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		document=MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getSelectionModel().getSlots().get(0).getTextEditor().getDoc();
		tp=MainFrame.getInstance().getWorkspaceTabbedMenu().getCurrentView().getCurrentView().getSelectionModel().getSlots().get(0).getTextEditor().getTP();
        try {
			document.insertString(0, tp.getText(), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}
        tp.addCaretListener(new SelectedText(document));
		Style style=StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		Style bold=document.addStyle("bold", style);
		StyleConstants.setBold(bold, true);
		try {
			tp.setText(document.getText(0, document.getLength()));
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}
}
