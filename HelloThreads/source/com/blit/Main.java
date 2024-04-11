package com.blit;

public class Main {
	public static void main (String[] args) {
		/* Thread can be created in 2 ways. 
		 * First is by EXTENDING the Thread class.
		 * 
		 * Can also IMLPEMENT the Runnable interface. 
		 */
		for (int i = 0; i < 5; i++) {
			MyThread mt = new MyThread(i);
			mt.start();
			try {
				mt.join(); /* Waits for previous thread to die. */
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Main thread.");
	}

	/* What is a synchronized method? */

	/* What is a synchronized block? */

	/* What is the executor service? */

	/* What is a deadlock? */
}