package controller;


public class ActionManager {
	private static ActionManager instance=null;
	
	private AboutAction aboutActionListener;
	
	private NewDocumentAction newDocumentAction;
	
	private ActionManager() {
		aboutActionListener=new AboutAction();
		newDocumentAction=new NewDocumentAction();
	}
	
	public AboutAction getAboutActionListener() {
		return aboutActionListener;
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
