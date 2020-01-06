package designmode.controller;

import java.util.ArrayList;

import controller.ActionManager;

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
			ActionManager.getInstance().getCommandActions().get(0).setEnabled(true);
		}
		if(currentCommand==commands.size()) {
			ActionManager.getInstance().getCommandActions().get(1).setEnabled(false);
		}
	}
	
	public void undoCommand() {
		if(currentCommand>0) {
			ActionManager.getInstance().getCommandActions().get(1).setEnabled(true);
			currentCommand--;
			commands.get(currentCommand).undoCommand();
		}
		if(currentCommand==0) {
			ActionManager.getInstance().getCommandActions().get(0).setEnabled(false);
		}
	}
}
