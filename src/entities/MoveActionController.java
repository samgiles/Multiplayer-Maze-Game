package entities;

import com.MoveDirection;

/**
 * Listens for a Movement Action and makes some arbitrary decision on allowing the move event to be handled by the registered MoveHandler.
 * @author Samuel Giles
 *
 */
public abstract class MoveActionController extends MovementListener {

	private MovementListener listener;
	
	private MoveActionController chain = null;
	
	public MoveActionController(MovementListener moveListener, MoveActionController chain) {
		listener = moveListener;
		this.chain = chain;
	}
	
	protected boolean checkAction(MoveDirection direction) {
		if (chain != null) {
			return chain.checkAction(direction);
		}
		
		return true;
	}
	
	@Override
	public void onMoveUp() {
		if (checkAction(MoveDirection.UP)) {
			listener.onMoveUp();
		}
	}

	@Override
	public void onMoveDown() {
		if (checkAction(MoveDirection.DOWN)) {
			listener.onMoveDown();
		}
	}

	@Override
	public void onMoveLeft() {
		if (checkAction(MoveDirection.LEFT)) {
			listener.onMoveLeft();
		}
	}

	@Override
	public void onMoveRight() {
		if (checkAction(MoveDirection.RIGHT)) {
			listener.onMoveRight();
		}
	}
	
	
}
