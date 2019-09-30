package io.concepts;

/** 
 * Example to show use of Thread Class Join method
 * @author rajesh
 *
 */
public class JoinExample {
	int count = 0 ;
	
	private void increment() {
		 count++;
	}

	public static void main(String[] args) throws InterruptedException {
		JoinExample ex = new JoinExample();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i =0 ; i <10000; i++) {
					ex.increment();
				}
				
			}
			
		});
		
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i =0 ; i <10000; i++) {
					ex.increment();
				}
				
			}
			
		});
		
		t1.start();
	//	t1.join(); //Main Thread waits till t1 thread is complete
		System.out.println("count : "+ex.count);
		t2.start();
		t2.join();
		System.out.println("count : "+ex.count);
		
	}

}
