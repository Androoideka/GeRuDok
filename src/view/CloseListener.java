package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controller.SaveRepository;
import exceptionhandling.ExceptionHandler;
import workspace.model.MPNode;

public class CloseListener extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent arg0) {
		MainFrame frame= MainFrame.getInstance();
		MPNode ws = (MPNode)MainFrame.getInstance().getWorkspaceTree().getRoot();
		try {
			if(ws.isChanged()) {
				throw new UnsavedWorkspaceException();
			}

		}
		catch (UnsavedWorkspaceException e) {
			String value = ExceptionHandler.createDialog(new UnsavedWorkspaceException());
			int buttonClicked = Integer.parseInt(value);
			if(buttonClicked == JOptionPane.CANCEL_OPTION) {
				frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			}
			else {
				if(buttonClicked == JOptionPane.YES_OPTION) {
					SaveRepository save = new SaveRepository();
					save.save(ws);
				}
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		}
		catch (Exception e) {
			ExceptionHandler.createDialog(e);
		}
	}

}
