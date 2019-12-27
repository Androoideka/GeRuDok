package designmode.model;

import java.awt.geom.Point2D;

import document.model.Slot;
import document.view.MainPageDrawer;

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

	public StateManager(MainPageDrawer pageView) {
		rectangleState = new RectangleState(pageView);
		triangleState = new TriangleState(pageView);
		circleState = new CircleState(pageView);
		selectState = new SelectState(pageView);
		rescaleState = new RescaleState(pageView);
		rotateState = new RotateState(pageView);
		grabState = new GrabState(pageView);
		deleteState = new DeleteState(pageView);
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
	
	public void setDeleteState() {
		if(currentState == selectState) {
			currentState = deleteState;
			deleteState.deleteSlot(selectState.getSelectedSlot());
		}
	}
	
	public void setSelectState() {
		currentState = selectState;
	}
	
	public State getCurrentState() {
		return currentState;
	}
}
