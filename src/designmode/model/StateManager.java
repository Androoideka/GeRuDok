package designmode.model;

import java.awt.geom.Point2D;

import document.model.Slot;
import workspace.model.Document;

public class StateManager {
	private State currentState;
	private CircleState circleState;
	private RectangleState rectangleState;
	private TriangleState triangleState;
	private SelectState selectState;
	private RescaleState rescaleState;
	private RotateState rotateState;
	private GrabState grabState;

	public StateManager(Document doc) {
		rectangleState = new RectangleState(doc);
		triangleState = new TriangleState(doc);
		circleState = new CircleState(doc);
		selectState = new SelectState(doc);
		rescaleState = new RescaleState(doc);
		rotateState = new RotateState(doc);
		grabState = new GrabState(doc);
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
	
	public void setRescaleState(Slot slot, Point2D start) {
		currentState=rescaleState;
		rescaleState.setSlot(slot, start);
	}
	
	public void setRotateState(Slot slot, Point2D start) {
		currentState=rotateState;
		rotateState.setSlot(slot, start);
	}
	
	public void setGrabState(Slot slot, Point2D start) {
		currentState=grabState;
		grabState.setSlot(slot, start);
	}
	
	public void setSelectState() {
		currentState = selectState;
	}
	
	public State getCurrentState() {
		return currentState;
	}
}
