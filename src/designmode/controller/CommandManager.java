package designmode.controller;

import java.util.ArrayList;

import controller.ActionManager;
import view.MainFrame;

public class CommandManager {
	private ArrayList<AbstractCommand> commands=new ArrayList<>();
	private int currentCommand=0;
	
	public void addCommand(AbstractCommand command) {
		while(currentCommand<commands.size()) {
			commands.remove(currentCommand);
		}
		commands.add(command);
		doCommand();
	}

	public void doCommand() {
		if(currentCommand<commands.size()) {
			commands.get(currentCommand).doCommand();
			currentCommand++;
			ActionManager.getInstance().getEditActions().get(5).setEnabled(true);
		}
		if(currentCommand==commands.size()) {
			ActionManager.getInstance().getEditActions().get(6).setEnabled(false);
		}
	}
	
	public void undoCommand() {
		if(currentCommand>0) {
			ActionManager.getInstance().getEditActions().get(6).setEnabled(true);
			currentCommand--;
			commands.get(currentCommand).undoCommand();
		}
		if(currentCommand==0) {
			ActionManager.getInstance().getEditActions().get(5).setEnabled(false);
		}
	}
}
