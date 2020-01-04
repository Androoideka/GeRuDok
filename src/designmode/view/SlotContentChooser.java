package designmode.view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import document.model.Slot;

public class SlotContentChooser extends JDialog {
	private Object selection;
	
	public SlotContentChooser(Slot s) {
		setDefaultLookAndFeelDecorated(true);
		String[] options = { "Textual", "Multimedial"};
		String initialSelection=options[0];
		selection=JOptionPane.showInputDialog(null, "Choose content type for this slot: ", "Slot content chooser", JOptionPane.OK_CANCEL_OPTION, null, options, initialSelection);
	}
	
	public String getSelection() {
		return (String)selection;
	}
}
