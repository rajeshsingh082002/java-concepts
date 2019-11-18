package io.ds;

public class MyHashMap<K,V> {

	private int size;
	private Object[] myStore;
	private static int DEFAULT_SIZE = 5;
	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<>();
		map.put(1,"Rajesh");
		map.put(2,"John");
		map.put(2,"Peter");
		System.out.println(map.get(2));

	}

	public MyHashMap() {
		myStore = new Object[DEFAULT_SIZE];
	}
	
	public void put(K k, V v) {
		Node<K,V> newNode =  new Node(k.hashCode(), k,v,null);
		int myHasCode = getMyHashCode(k.hashCode());
		if(myStore[myHasCode] == null) {
			myStore[myHasCode] = newNode ;
		} else {
			Node<K,V> currentNode = (Node<K,V>) myStore[myHasCode];
			while(currentNode.next !=null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
		
	}
	
	public V get(K k) {
		int myHashCode = getMyHashCode(k.hashCode());
		Node<K,V> node = (Node)myStore[myHashCode];
		Node<K,V> currentNode;
		if(node.next != null) {
			currentNode = node.next;
			if(k.equals(currentNode.k)) {
				node  = currentNode;
			}
		}   
		return node.v;
	}
	
	private int getMyHashCode(int hashCode) {
		return hashCode%DEFAULT_SIZE;
	}
	
	private class Node<K,V> {
		Node<K,V> next;
		K k;
		V v;
		int hashCode;
		
		public Node(int hashCode, K k,V v,Node<K,V> next) {
			this.hashCode = hashCode;
			this.k = k;
			this.v = v;
			this.next = next;
		}
	}
}
