package kata_list_by_array;

import java.util.ArrayList;

public class ListByArrayListImpl<T> implements CustomList<T> {

	private CustomList<T> listByArrayList = (CustomList<T>) new ArrayList<T>();
	
	public void add(T item) {
		listByArrayList.add(item);
	}

	public T get(int index) {
		return listByArrayList.get(index);
	}

	public T remove(int index) {
		return listByArrayList.remove(index);
	}

	public boolean contains(Object item) {
		return listByArrayList.contains(item);
	}

}
