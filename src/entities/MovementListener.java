package entities;

/**
 * The listener interface for receiving game control events.
 * @author Samuel Giles
 */
public abstract class MovementListener {

	/**
	 * Invoked when the Game control for Up is triggered.
	 */
	public void onMoveUp(){
		// Called when a MovementHandler triggers a move Up.
	}
	
	/**
	 * Invoked when the Game control for down is triggered.
	 */
	public void onMoveDown(){
		// Called when a MovementHandler triggers a move Down.
	}
	
	/**
	 * Invoked when the Game control for left is triggered.
	 */
	public void onMoveLeft(){
		// Called when a MovementHandler triggers a move Up.
	}
	
	/**
	 * Invoked when the Game control for right is triggered.
	 */
	public void onMoveRight(){
		// Called when a MovementHandler triggers a move Down.
	}
	
}
