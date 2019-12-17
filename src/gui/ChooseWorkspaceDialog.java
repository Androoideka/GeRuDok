package gui;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ChooseWorkspaceDialog extends JDialog {
	private static ChooseWorkspaceDialog instance=null;
	
	private ChooseWorkspaceDialog(MainFrame frame) {
		super(frame, "Choose a workspace");
		JButton openBtn=new JButton("Yes");
		JButton closeBnt=new JButton("No");
		
	}
	
	public static ChooseWorkspaceDialog getInstance() {
		if(instance==null) {
			instance=new ChooseWorkspaceDialog(MainFrame.getInstance());
		}
		return instance;
	}
}
