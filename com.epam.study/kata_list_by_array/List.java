package kata_list_by_array;

public interface List<T> {

	void add(T item);
	
	T get(int index);
	
	T[] remove(int index);
	
	boolean contains(Object item);
}
