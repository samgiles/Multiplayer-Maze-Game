/**
 * 
 */
package tests.entities.mockobjects;

import entities.MoveDirection;
import entities.MoveHandler;

/**
 * @author sam
 *
 */
public class MockMoveHandler extends MoveHandler {

	public MockMoveHandler() {
		super();
	}
	
	public void triggerUp() {
		this.notify(MoveDirection.UP);
	}
	
	public void triggerDown() {
		this.notify(MoveDirection.DOWN);
	}
	
	public void triggerLeft() {
		this.notify(MoveDirection.LEFT);
	}
	
	public void triggerRight() {
		this.notify(MoveDirection.RIGHT);
	}
	
	public void triggerIllegalArgument() {
		this.notify(MoveDirection.valueOf("Invalid"));
	}
}
