package kata_list_by_array;

import java.lang.reflect.Array;

public class ListImpl<T> {	

	T[] listByArray;
	Class<T> clazz;
	
	public ListImpl(Class<T> clazz/*, int length*/) {
		this.clazz = clazz;
		listByArray = (T[]) Array.newInstance(clazz, 100);
	}
	
	public void add(T item) {
		T[] tempArray = (T[]) Array.newInstance(clazz, listByArray.length + 1);
		
		for(int i = 0; i < listByArray.length; i++) {
			tempArray[i] = listByArray[i];
		}
		
		tempArray[tempArray.length - 1] = item;
		
		listByArray = (T[]) Array.newInstance(clazz, tempArray.length);
		listByArray = tempArray;
	}
	
	public T get(int index) {
		return listByArray[index];
	}
	
	public T[] remove(int index) {
		T[] tempArray = (T[]) Array.newInstance(clazz, listByArray.length - 1);
		
		for (int i = 0; i < tempArray.length; i++) {
			if(i < index) {
				tempArray[i] = listByArray[i];
			} else {
				tempArray[i] = listByArray[i + 1];
			}
		}
		
		listByArray = (T[]) Array.newInstance(clazz, tempArray.length);
		listByArray = tempArray;
		return listByArray;
	}
	
	public boolean contains(Object item) {
		for (int i = 0; i < listByArray.length; i++) {
			if (listByArray[i].equals(item)) {
				return true;
			}
		}
		return false;
	}
}