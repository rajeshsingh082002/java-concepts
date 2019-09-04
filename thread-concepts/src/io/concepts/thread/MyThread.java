package io.concepts.thread;

/**
 * This class shows different ways to instantiate thread
 * @author rajesh
 *
 */
public class MyThread {

	public static void main(String[] args) {
		
	new Thread(()-> System.out.println("Runing in thread using lamda")).start(); // Using Lamda
	
	new Thread(new Runnable() {

		@Override
		public void run() {
			System.out.println("Runing in thread using inner class"); // using pre java 8
			
		}
		
	}).start();;

	}

}
