package state;

import model.workspace.Document;

public class StateManager {
	private State currentState;
	private CircleState circleState;
	private RectangleState rectangleState;
	private TriangleState triangleState;
	private SelectState selectState;

	public StateManager(Document doc) {
		rectangleState = new RectangleState(doc);
		triangleState = new TriangleState(doc);
		circleState = new CircleState(doc);
		selectState = new SelectState(doc);
		
		currentState = selectState;
	}
	public void setRectangleState() {
		if(currentState == selectState) {
			selectState.deselect();
			selectState.unrotatable();
		}
		currentState = rectangleState;
	}
	
	public void setTriangleState() {
		if(currentState==selectState) {
			selectState.deselect();
			selectState.unrotatable();
		}
		currentState=triangleState;
	}
	
	public void setCircleState() {
		if(currentState==selectState) {
			selectState.deselect();
			selectState.unrotatable();
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
