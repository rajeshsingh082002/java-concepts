package io.thread;

/**
 * Different ways to create Thread
 * @author rajesh
 *
 */
public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1  = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Tread created using annonymus inner class");
			}
		});
		t1.start();
		
		//Thread Using Lambda
		Thread t2 = new Thread(() -> System.out.println("Thread Using Lambda"));
		t2.start();
		}


		
		
	}
	



