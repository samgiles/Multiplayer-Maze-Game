package entities;

/**
 * The listener interface for receiving game control events.
 * @author Samuel Giles
 */
public abstract class MovementListener {

	/**
	 * Invoked when the Game control for Up is triggered.
	 */
	public abstract void onMoveUp();
	
	/**
	 * Invoked when the Game control for down is triggered.
	 */
	public abstract void onMoveDown();
	
	/**
	 * Invoked when the Game control for left is triggered.
	 */
	public abstract void onMoveLeft();
	
	/**
	 * Invoked when the Game control for right is triggered.
	 */
	public abstract void onMoveRight();
	
}
