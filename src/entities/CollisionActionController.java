package entities;

import game.Game;
import maze.MazeController;

import com.MoveDirection;

public class CollisionActionController extends MoveActionController {

	private Game game;
	private EntityController entityController;

	public CollisionActionController(MovementListener listener, Game game, EntityController entity) {
		super(listener, null);
		this.game = game;
		this.entityController = entity;
	}
	
	public CollisionActionController(MovementListener listener, Game game, EntityController entity, MoveActionController chain) {
		super(listener, chain);
		this.game = game;
		this.entityController = entity;	
	}
	
	@Override
	protected boolean checkAction(MoveDirection direction) {
		
		boolean thisResult = game.getMaze().queryCollision(
				(int)entityController.getEntity().getPositionY(),
				(int)entityController.getEntity().getPositionX(), direction);
		
		return super.checkAction(direction) && thisResult; // Must call super to try and invoke any chained Handlers.
	}
}