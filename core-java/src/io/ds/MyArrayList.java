package io.ds;

import java.util.Arrays;

/**
 * Array based list of Objects
 * @author rajesh
 *
 */
public class MyArrayList<E> {
	private Object[] store;
	private int size;
	private int newSize; //used for increasing size at runtime
	private int index;
	
	public MyArrayList(int size) {
		if(size <=0) {
			throw new RuntimeException("Please Enter size > 0 ");
		}
		store  = new Object[size];
		this.size = size;
		index = -1;
	}

	public boolean add(E e) {
		checkSize();
		store[++index] = e;
		return true;
	}
	
	public E get(int index) {
		rangeCheck();
		return (E) store[index];
	}
	
	public void travers() {
		for (Object object : store) {
			System.out.println((E) object);
		}
	}
	
	private void rangeCheck() {
		if(index <=0 || index > store.length) {
			throw new RuntimeException("Index is not in array limits ");
		}
	}
	
	

	private void checkSize() {
		if(index  == size-1) {
			newSize = size*2;
			store = Arrays.copyOf(store, newSize);
			size = newSize;
		}
		
	}
	public static void main(String[] args) {
		MyArrayList <String> myList = new MyArrayList<>(2);
		myList.add("Rajesh");
		myList.add("John");
		myList.add("Peter");
		myList.add("Dcosta");
		myList.add("Dcosta");
		myList.add("Dcosta");
		
		//System.out.println(myList.get(2));
		myList.travers();
		
	}

}
