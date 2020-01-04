package designmode.view;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class SelectedText implements CaretListener {
	private StyledDocument document;
	
	public SelectedText(StyledDocument document) {
		this.document=document;
	}
	
	public void caretUpdate(CaretEvent event) {
        int dot = event.getDot();
        int mark = event.getMark();
        if (dot != mark) {
            if (dot < mark) {
                int temp = dot;
                dot = mark;
                mark = temp;
            }
            boldSelectedText(mark, dot);
        }
    }

    private void boldSelectedText(int mark, int dot) {
        try {
            int length = dot - mark;
            String s = document.getText(mark, length);
            document.remove(mark, length);
            document.insertString(mark, s, document.getStyle("bold"));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

}
