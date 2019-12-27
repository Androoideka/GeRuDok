package designmode.model;

import java.awt.geom.Point2D;

import document.view.MainPageView;

public class StateManager {
	private State currentState;
	private CircleState circleState;
	private RectangleState rectangleState;
	private TriangleState triangleState;
	private SelectState selectState;
	private RescaleState rescaleState;
	private RotateState rotateState;
	private GrabState grabState;
	private DeleteState deleteState;

	public StateManager(MainPageView mainPageView) {
		rectangleState = new RectangleState(mainPageView);
		triangleState = new TriangleState(mainPageView);
		circleState = new CircleState(mainPageView);
		selectState = new SelectState(mainPageView);
		rescaleState = new RescaleState(mainPageView);
		rotateState = new RotateState(mainPageView);
		grabState = new GrabState(mainPageView);
		deleteState = new DeleteState(mainPageView);
		currentState = selectState;
	}
	public void setRectangleState() {
		if(currentState == selectState) {
			selectState.deselect();
		}
		currentState = rectangleState;
	}
	
	public void setTriangleState() {
		if(currentState==selectState) {
			selectState.deselect();
		}
		currentState=triangleState;
	}
	
	public void setCircleState() {
		if(currentState==selectState) {
			selectState.deselect();
		}
		currentState=circleState;
	}
	
	public void setRescaleState(Point2D start) {
		currentState=rescaleState;
		rescaleState.setPoint(start);
	}
	
	public void setRotateState(Point2D start) {
		currentState=rotateState;
		rotateState.setPoint(start);
	}
	
	public void setGrabState(Point2D start) {
		currentState=grabState;
		grabState.setPoint(start);
	}
	
	public void setDeleteState() {
		if(currentState == selectState) {
			currentState = deleteState;
			deleteState.deleteSlot();
		}
	}
	
	public void setSelectState() {
		currentState = selectState;
	}
	
	public State getCurrentState() {
		return currentState;
	}
}
