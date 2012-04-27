package store;

import com.db4o.ObjectSet;

public interface IDataSource<T> {
	
	/**
	 * Stores an object to the datasource.
	 * @param object T The object to store in the Datasource.
	 * @return boolean Returns true on the successful storage of the object, false on failure
	 */
	public boolean store(T object);
	
	/**
	 * Loads an object from the datasource.
	 * @return T The loaded object.
	 */
	public ObjectSet<T> query(T prototype);
}