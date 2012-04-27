package store;

import com.db4o.ObjectSet;

public class DataSourceFactory {

	public static <T> IDataSource<T> createTypedObjectStore(Class<T> type) throws Exception {
		
		IDataSource<T> source = new DB4ODataSource<T>(type);
		return source;
	}
	
	public static <T> IDataSource<T> createMockTypedObjectStore(Class<T> type) throws Exception {
		
		IDataSource<T> source = new IDataSource<T>() {

			@Override
			public boolean store(T object) {
				return true;
			}

			@Override
			public ObjectSet<T> query(T prototype) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		return source;
	}
}