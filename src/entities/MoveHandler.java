package entities;

import java.util.*;

/**
 * Provides a common interface for handling the movement of an entity.
 * @author Samuel Giles
 */
public abstract class MoveHandler {
	
	/**
	 * A list of all MovementListeners that have listened to this MovementHandler.
	 */
	private List<MovementListener> listeners;
	
	/**
	 * Construct the MoveHandler and set up the listening mechanism.
	 */
	public MoveHandler() {
		listeners = new LinkedList<MovementListener>();
	}
	
	public void listen(MovementListener listener){
		listeners.add(listener);
	}
	
	/**
	 * Notifies listeners about a game movement event.
	 * @param direction MoveDirection The direction that the handler is notfying listeners about.
	 */
	protected void notify(MoveDirection direction) {
		
		Iterator<MovementListener> it = listeners.iterator();
		
		while(it.hasNext()) {
			MovementListener listener = it.next();
			
			switch (direction) {
				case DOWN:
					listener.onMoveDown();
					break;
				case UP:
					listener.onMoveUp();
					break;
				case LEFT:
					listener.onMoveLeft();
					break;
				case RIGHT:
					listener.onMoveRight();
					break;
				default:
					throw new IllegalArgumentException("The argument, direction, was not a valid MoveDirection argument.");
			}
		}
	}
}
