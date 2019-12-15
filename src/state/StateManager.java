package state;

import model.workspace.Document;

public class StateManager {
	private State currentState;
	
	private RectangleState rectangleState;
	private SelectState selectState;

	public StateManager(Document mediator) {
		rectangleState = new RectangleState(mediator);
		selectState = new SelectState(mediator);
		
		currentState = selectState;
	}
	public void setRectangleState() {
		currentState = rectangleState;
	}
	public void setSelectState() {
		currentState = selectState;
	}
	public State getCurrentState() {
		return currentState;
	}
}
