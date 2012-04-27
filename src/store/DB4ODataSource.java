package store;

import java.lang.reflect.Type;  
import java.lang.reflect.Field;  
import java.lang.reflect.ParameterizedType;  
import com.db4o.*;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;

class DB4ODataSource<T> implements IDataSource<T> {

	private final String db4oBaseFileName = "Store";
	
	private ObjectContainer db;
	
	public DB4ODataSource(Class<T> type) throws Exception {
		
		String typeName = type.getName();
		db = Db4oEmbedded.openFile(typeName + db4oBaseFileName);
	}
	
	@Override
	public boolean store(T object) {
		try {
			db.store(object);
		} catch(DatabaseClosedException e) {
			// TODO logging.
			return false;
			
		} catch(DatabaseReadOnlyException e) {
			
			return false;
			
		}
		
		return true;
	}

	@Override
	public ObjectSet<T> query(T proto) {
		ObjectSet<T> result = db.queryByExample(proto);
				
		return result;
	}
	
	public void close() {
		db.close();
	}
	
	@Override
	public void finalize() {
		if (db != null){
			close();
		}
	}

}
