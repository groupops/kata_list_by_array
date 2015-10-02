package kata_list_by_array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ListImpl<T> {	

	private static final int INITIAL_SIZE = 100; 
	private T[] listByArray;
	private Class<T> clazz;
	private int numberOfElements;
	
	public ListImpl(Class<T> clazz) {
		this.clazz = clazz;
		listByArray = (T[]) Array.newInstance(clazz, INITIAL_SIZE);
	}
	
	public void add(T item) {
		if (numberOfElements == listByArray.length) {
			listByArray = Arrays.copyOf(listByArray, 100);
		}
		
		listByArray[numberOfElements] = item;
		numberOfElements++;
	}
	
	public T get(int index) {
		return listByArray[index];
	}
	
	public T[] remove(int index) {
		T[] tempArray = (T[]) Array.newInstance(clazz, numberOfElements - 1);
		
		for (int i = 0; i < tempArray.length; i++) {
			if(i < index) {
				tempArray[i] = listByArray[i];
			} else {
				tempArray[i] = listByArray[i + 1];
			}
		}
		
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