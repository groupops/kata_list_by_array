package kata_list_by_array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ListImpl<T> implements CustomList<T> {	

	private static final int INITIAL_SIZE = 100; 
	private T[] listByArray;
	private int numberOfElements;
	
	public ListImpl(Class<T> clazz) {
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
	
	public T remove(int index) {
		if (numberOfElements > 0) {
			T elementToRemove = listByArray[index];
			
			if (index != numberOfElements) {
				System.arraycopy(listByArray, index + 1, listByArray, index, numberOfElements - index - 1);
			}
			
			listByArray[numberOfElements - 1] = null;
			
			numberOfElements--;
			return elementToRemove;
		} else {
			return null;
		}
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