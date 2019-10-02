package io.ds;

public class MyLinkedList<T> {
	private Node<T> head;
	private Node<T> current;
	
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.traverse();
		list.add("John");
		list.add("Paul");
		list.add("Marry");
		list.traverse();
	}

	public void add(T t) {
		Node<T> node  = new Node(t);
		if(head == null) {
			head = node;
			current = node;
		} else {
			while(current.getNext() != null) {
				current = head.getNext();
			}
			current.setNext(node);
		}
		
	}
	
	public void traverse() {
		if(head == null) {
			throw new RuntimeException("MyList is Emplty");
		}
		Node<T> current = head;
		while(current !=null) {
			System.out.println(current.getT());
			current = current.getNext();
		}
	}

	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}

}

class Node<T> {
	private T t;
	private Node next;
	
	public Node (T t) {
		this.t=t;
		this.next = null;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}