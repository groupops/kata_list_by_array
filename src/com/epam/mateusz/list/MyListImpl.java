package com.epam.mateusz.list;

public class MyListImpl<T> implements MyList<T>{

    private static final int DEFAULT_SIZE = 10;
    
    private T myList[];
    private int size;
    
    
    @SuppressWarnings("unchecked")
    public MyListImpl(){
        myList = (T[])new Object[DEFAULT_SIZE];
    }
    
    @Override
    public void add(T item) {
        try{
            myList[size] = item;
        }
        catch(IndexOutOfBoundsException e){
            enlarge();
            myList[size] = item;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        return myList[index];
    }

    @Override
    public T remove(int index) {
        T removedItem = myList[index];
        for(int i=index; i<size-1; i++){
            myList[i] = myList[i+1];
        }
        size--;
        
        if(size%10 == 0)
            shrink();
        
        return removedItem;
    }

    @Override
    public Boolean contains(T item) {
        for(int i=0; i<size; i++){
            if(myList[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
    
    @SuppressWarnings("unchecked")
    private void enlarge(){
        T tempList[] = (T[])new Object[size+10];
        for(int i=0; i<size; i++){
            tempList[i] = myList[i];
        }
        myList = tempList;
    }
    
    private void shrink(){
        T tempList[] = (T[])new Object[myList.length-10];
        for(int i=0; i<size; i++){
            tempList[i] = myList[i];
        }
        myList = tempList;
    }
    
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        
        for(int i=0; i<size; i++){
            stringBuilder.append(myList[i].toString());
            if(i<size-1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        
        return stringBuilder.toString();
    }

}
