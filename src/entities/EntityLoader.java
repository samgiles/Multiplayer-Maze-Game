package entities;

import com.db4o.ObjectSet;

import store.DataSourceFactory;
import store.IDataSource;

public class EntityLoader {
	
	IDataSource<Entity> dataSource;
	
	public EntityLoader() {
		try {
			dataSource = DataSourceFactory.createTypedObjectStore(Entity.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Entity getPlayerByName(String name) {
		ObjectSet<Entity> result = dataSource.query(new Entity(name));
		
		if (result.size() == 0) {
			return null;
		}
		
		return result.get(0);
	}
	
	public void savePlayer(Entity entity) {
		boolean result = dataSource.store(entity);
		
		if (!result) {
			// TODO logging.
		}
	}
	
}
