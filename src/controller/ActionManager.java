package controller;


public class ActionManager {
	private static ActionManager instance=null;
	
	private AboutActionListener aboutActionListener;
	
	private NewDocumentAction newDocumentAction;
	
	private ActionManager() {
		aboutActionListener=new AboutActionListener();
		newDocumentAction=new NewDocumentAction();
	}
	
	public AboutActionListener getAboutActionListener() {
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
