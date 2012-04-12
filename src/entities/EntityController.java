package entities;

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
	
	public EntityController(Entity entity, MoveHandler moveHandler) {
		this.entity = entity;
		this.moveHandler = moveHandler;
		
		this.registerMovementListener();
	}
	
	/**
	 * Register this EntityControllers MovementListener anonymous class, defined in MovemenetListener.getListener with the move handler.
	 */
	private void registerMovementListener() {
		this.moveHandler.listen(this.getListener());
	}
	
	/**
	 * Returns an anonymous class that can be used to respond to MoveHandler notifications.
	 * @return
	 */
	private MovementListener getListener() {
		return new MovementListener() {

			@Override
			public void onMoveUp() {
				EntityController.this.entity.addToPositionY(-MOVE_CONSTANT);
			}

			@Override
			public void onMoveDown() {
				EntityController.this.entity.addToPositionY(MOVE_CONSTANT);
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
		graphics.drawText("O", (float)this.entity.getPositionX(), (float)this.entity.getPositionY());
	}
	
	/**
	 * Get the entity that this controller is responsible for.
	 * @return Entity
	 */
	public Entity getEntity() {
		return this.entity;
	}
} 
