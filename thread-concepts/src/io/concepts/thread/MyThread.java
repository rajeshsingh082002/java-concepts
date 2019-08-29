package io.concepts.thread;

public class MyThread {

	public static void main(String[] args) {
		
	new Thread(()-> System.out.println("Runing in thread")).start();

	}

}
