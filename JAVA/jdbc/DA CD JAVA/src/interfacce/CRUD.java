package interfacce;

public interface CRUD {

	public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	public static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public boolean insert(Object obj);

	public boolean update(Object obj);

	public boolean delete(long stt);

}
