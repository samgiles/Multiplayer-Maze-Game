package entities;

import store.IDataSource;

/**
 * Used to load Entities from a data source.
 * @author Samuel Giles
 *
 */
public class EntityLoader {
	
	/**
	 * The data source this entity loader will use to load the entites from.
	 */
	private final IDataSource<Entity> dataSource;
	
	public EntityLoader(IDataSource<Entity> entityDataSource) {
		this.dataSource = entityDataSource;
	}
	
	/**
	 * Store the entity.
	 * @param entity Entity The entity to store.
	 * @return boolean Returns true on success false on failure.
	 */
	public boolean store(Entity entity) {
		return dataSource.store(entity);
	}
	
	/**
	 * Loads an entity.
	 * @return The entity loaded from the datasource.
	 */
	public Entity load(){
		return dataSource.load();
	}
}
