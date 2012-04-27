package entities;

import game.Game;
import maze.MazeController;

import com.MazeCompletedAction;
import com.graphics.IGraphicsContext;

/**
 * Controls an entities interactions.
 * @author Samuel Giles
 */
public class EntityController {
	/**
	 * The entity that this Entity Controller is controlling.
	 */
	private final Entity entity;
	
	public static int MOVE_CONSTANT = 1;
	
	/**
	 * The move handler that controls this entities movement.
	 */
    private final MoveHandler moveHandler;
    
    private final Game game;
	
	public EntityController(Game game, Entity entity, MoveHandler moveHandler) {
		this.entity = entity;
		this.game = game;
		this.moveHandler = moveHandler;
		resetPosition();
		this.registerMovementListener();
	}
	
	public void resetPosition() {
		this.entity.setPositionX(game.getMaze().getStart().getX());
		this.entity.setPositionY(game.getMaze().getStart().getY());
	}
	
	/**
	 * Register this EntityControllers MovementListener anonymous class, defined in MovemenetListener.getListener with the move handler.
	 */
	private void registerMovementListener() {
		
		this.moveHandler.listen(
				new CollisionActionController(this.getListener(), game, this, 
						new MazeCompleteActionController(this.getListener(), new MazeCompletedAction() {

							@Override
							public void mazeCompleted(EntityController entity,
									MazeController maze) {
								// Maze Completed! Notify the game!
								System.out.println("Game Completed!");
								
								entity.entity.setScore(entity.entity.getScore() + 1);
								
								game.mazeCompleted(maze, entity);
							}}, game, this)));
	}
	
	/**
	 * Returns an anonymous class that can be used to respond to MoveHandler notifications.
	 * @return
	 */
	private MovementListener getListener() {
		return new MovementListener() {

			@Override
			public void onMoveUp() {
				EntityController.this.entity.addToPositionY(MOVE_CONSTANT);
			}

			@Override
			public void onMoveDown() {
				EntityController.this.entity.addToPositionY(-MOVE_CONSTANT);
			}

			@Override
			public void onMoveLeft() {
				EntityController.this.entity.addToPositionX(-MOVE_CONSTANT);
			}

			@Override
			public void onMoveRight() {
				EntityController.this.entity.addToPositionX(MOVE_CONSTANT);
			}
			
		};
	}
	
	public void draw(IGraphicsContext graphics) {
		// TODO
		graphics.setColor(0xFF, 0, 0);
		graphics.fillOval(
				(int)(((float)this.entity.getPositionX() + 1) * 30) - 20,  // X
				(int)(Math.abs(((float)this.entity.getPositionY() - 10)) * 30) - 20, // Y
				10, 10);
	}
	
	/**
	 * Get the entity that this controller is responsible for.
	 * @return Entity
	 */
	public Entity getEntity() {
		return this.entity;
	}
} 
