package io.ds;

/**
 * Array based Stack Implementation
 * 
 * @author rajesh
 *
 * @param <T>
 */
public class Stack<T> {
	private int top;
	private int capacity;
	Object[] stack;

	public Stack (int size) {
		 stack = new Object[size];
		 capacity = size;
		 top =-1;
	}
	
	public void push(T t ) {
		if(top == capacity-1) {
			throw new RuntimeException("Stack Capacity reached");
		}
		stack[++top] = t;
	}
	
	public T pop() {
		if(top==-1) {
			throw new RuntimeException("Stack is Empty");
		}
		return (T) stack[top--];
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>(5);
		stack.push("Tony");
		stack.push("George");
		stack.push("John");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	

}
