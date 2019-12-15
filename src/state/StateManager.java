package state;

import model.workspace.Document;

public class StateManager {
	private State currentState;
	private CircleState circleState;
	private RectangleState rectangleState;
	private SelectState selectState;

	public StateManager(Document doc) {
		rectangleState = new RectangleState(doc);
		circleState = new CircleState(doc);
		selectState = new SelectState(doc);
		
		currentState = selectState;
	}
	public void setRectangleState() {
		if(currentState == selectState) {
			selectState.deselect();
		}
		currentState = rectangleState;
	}
	
	public void setCircleState() {
		if(currentState==selectState) {
			selectState.deselect();
		}
		currentState=circleState;
	}
	
	public void setSelectState() {
		currentState = selectState;
	}
	public State getCurrentState() {
		return currentState;
	}
}
