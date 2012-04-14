package entities;

import maze.MazeController;

import com.MoveDirection;

public class CollisionActionController extends MoveActionController {

	private MazeController mazeController;
	private EntityController entityController;

	public CollisionActionController(MovementListener listener, MazeController mazeController, EntityController entity) {
		super(listener, null);
		this.mazeController = mazeController;
		this.entityController = entity;
	}
	
	public CollisionActionController(MovementListener listener, MazeController mazeController, EntityController entity, MoveActionController chain) {
		super(listener, chain);
		this.mazeController = mazeController;
		this.entityController = entity;	
	}
	
	@Override
	protected boolean checkAction(MoveDirection direction) {
		
		boolean thisResult = mazeController.queryCollision(
				(int)entityController.getEntity().getPositionY(),
				(int)entityController.getEntity().getPositionX(), direction);
		
		return super.checkAction(direction) && thisResult; // Must call super to try and invoke any chained Handlers.
	}
}