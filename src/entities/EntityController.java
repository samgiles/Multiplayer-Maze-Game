package entities;

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
	
	
	public Entity getEntity() {
		return this.entity;
	}
} 
