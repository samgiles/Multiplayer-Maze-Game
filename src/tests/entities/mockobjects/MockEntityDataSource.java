package tests.entities.mockobjects;

import entities.Entity;
import store.IDataSource;

/**
 * A MockEntityDataSource that can be used for testing.
 * @author Samuel Giles
 */
public class MockEntityDataSource implements IDataSource<Entity> {
	
	private Entity storedEntity;
	
	/**
	 * Creates a new MockEntityDataSource.
	 */
	public MockEntityDataSource() {
		this.storedEntity = null;
	}
	
	/**
	 * Store the entity.
	 * @param entity Entity The entity to store.
	 * @return boolean Returns true on success false on failure.
	 */
	public boolean store(Entity entity) {
		if (entity != null) {
			this.storedEntity = entity;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Loads an entity.
	 * @return The entity loaded from the datasource.
	 */
	public Entity load(){
		return this.storedEntity;
	}

}
