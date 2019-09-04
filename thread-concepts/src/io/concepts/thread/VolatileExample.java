package io.concepts.thread;

import java.util.Scanner;

public class VolatileExample {

	volatile boolean isRunning = true; //Volatile keyword make thread to sync its value from master copy.

	public static void main(String[] args) {

		Processor task = new Processor();

		new Thread(task).start();
		System.out.println("Please Enter to Stop thread");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		task.shutDown();

	}

}

class Processor implements Runnable {
	volatile boolean isRunning = true;

	@Override

	public void run() {
		while (isRunning) {
			System.out.println("I am running");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public void shutDown() {
		isRunning = false;
	}
}
