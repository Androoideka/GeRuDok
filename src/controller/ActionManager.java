package controller;


public class ActionManager {
	private static ActionManager instance=null;
	
	private AboutAction aboutAction;
	
	private NewDocumentAction newDocumentAction;
	
	private ActionManager() {
		aboutAction=new AboutAction();
		newDocumentAction=new NewDocumentAction();
	}
	
	public AboutAction getAboutAction() {
		return aboutAction;
	}
	
	public NewDocumentAction getNewProjectAction() {
		return newDocumentAction;
	}
	
	public static ActionManager getInstance() {
		if(instance==null) {
			instance=new ActionManager();
		}
		return instance;
	}
}
