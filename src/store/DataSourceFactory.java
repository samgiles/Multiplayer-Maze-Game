package store;

public class DataSourceFactory {

	public static <T> IDataSource<T> createTypedObjectStore(Class<T> type) throws Exception {
		
		IDataSource<T> source = new DB4ODataSource<T>(type);
		return source;
	}
}