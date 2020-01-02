package designmode.controller;

public abstract class AbstractCommand {
	public abstract void doCommand();
	
	public abstract void undoCommand();
}
