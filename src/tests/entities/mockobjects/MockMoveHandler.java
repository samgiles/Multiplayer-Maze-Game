/**
 * 
 */
package tests.entities.mockobjects;

import com.MoveDirection;
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
		notify(MoveDirection.UP);
	}
	
	public void triggerDown() {
		notify(MoveDirection.DOWN);
	}
	
	public void triggerLeft() {
		notify(MoveDirection.LEFT);
	}
	
	public void triggerRight() {
		notify(MoveDirection.RIGHT);
	}
}
