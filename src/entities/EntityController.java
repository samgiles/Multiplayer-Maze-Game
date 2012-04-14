package entities;

import maze.MazeController;

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
	
	public EntityController(Entity entity, MoveHandler moveHandler, MazeController maze) {
		this.entity = entity;
		this.moveHandler = moveHandler;
		this.entity.setPositionX(maze.getStart().getY());
		this.entity.setPositionY(maze.getStart().getX());
		this.registerMovementListener(maze);
	}
	
	/**
	 * Register this EntityControllers MovementListener anonymous class, defined in MovemenetListener.getListener with the move handler.
	 */
	private void registerMovementListener(MazeController maze) {
		this.moveHandler.listen(new CollisionActionController(this.getListener(), maze, this));
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
