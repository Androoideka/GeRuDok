package controller;


public class ActionManager {
	private AboutActionListener aboutActionListener;
	
	private NewDocumentAction newDocumentAction;
	
	public ActionManager() {
		aboutActionListener=new AboutActionListener();
		newDocumentAction=new NewDocumentAction();
	}
	
	public AboutActionListener getAboutActionListener() {
		return aboutActionListener;
	}
	
	public NewDocumentAction getNewProjectAction() {
		return newDocumentAction;
	}
}
