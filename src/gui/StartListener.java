package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controller.OpenRepository;
import controller.SaveRepository;
import exceptionhandling.ExceptionHandler;
import model.workspace.MPNode;

public class StartListener extends WindowAdapter {
	public void windowActivated(WindowEvent arg0) {
		MainFrame frame= MainFrame.getInstance();
		MPNode ws = (MPNode)MainFrame.getInstance().getWorkspaceTree().getRoot();
		try {
			if(ws.isChanged()) {
				throw new NoPreveousWorkspaceFoundException();
			}else {
				//frame.getWorkspaceTree().setRoot(ws);
			}

		}
		catch (NoPreveousWorkspaceFoundException e) {
			String value = ExceptionHandler.createDialog(new NoPreveousWorkspaceFoundException());
			int buttonClicked = Integer.parseInt(value);
			if(buttonClicked == JOptionPane.YES_OPTION) {
				OpenRepository open=new OpenRepository();
				open.openDocument();
			}
			else {
				if(buttonClicked == JOptionPane.NO_OPTION) {
					
				}
			}
		}
		catch (Exception e) {
			ExceptionHandler.createDialog(e);
		}
		
		
		
		
		MainFrame frame= MainFrame.getInstance();
		MPNode ws = (MPNode)MainFrame.getInstance().getWorkspaceTree().getRoot();
		String[] options = {"Yes", "No"};
		int jebiSe=JOptionPane.showOptionDialog(frame,
				"Do you want to use an existing workspace?",
				"kurèina",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]
				);
		if(jebiSe==JOptionPane.YES_OPTION) {
			
		}else if(jebiSe==JOptionPane.NO_OPTION) {
			
		}
	}
}
