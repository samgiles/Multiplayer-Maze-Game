package entities;

/**
 * Controls an entities interactions.
 * @author Samuel Giles
 */
public class EntityController {
	/**
	 * The entity that this Entity Controller is controlling.
	 */
	private Entity entity;
  
	
	public EntityController(Entity entity) {
		this.entity = entity;
	}
	
	public Entity getEntity() {
		return this.entity;
	}
} 
