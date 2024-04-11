package com.blit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main (String[] args) {
		// testExecutor();
		testSync();
	}

	public static void testThreads () {
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

	public static void threadRunnable () {
		/* This thread uses a runnable method. */
		Thread t = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void syncmethod1 () {
		/* What is a synchronized method? 
		 * It is a method with a `monitor lock` on it that cannot be
		 * run by multiple threads until one thread is finished with it.
		 * Ensures thread saftey in multi-threaded programs.
		 * When the method accesses data objects that cannot be accessed
		 * in async, this is used.
		 */
		System.out.println("In method 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void notSyncMethod1 () {
		System.out.println("In unsync method 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void testSync () {
		/* Test the synchronization method. */
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(() -> {
				String threadId = Thread.currentThread().getId()+"";
				System.out.println("In thread: "+threadId);
				syncmethod1();
				//notSyncMethod1();
				try {
					Thread.sleep(1000);
					System.out.println(threadId+ " is done");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

			t.start();
			// try {
			// 	t.join();
			// } catch (InterruptedException e) {
			// 	e.printStackTrace();
			// }
		}
	}


	public static void syncBlock () {
		/* What is a synchronized block? 
		 * A code that is synchornized on a specified objects lock.
		 * Allows specific blocks of code to be synchronized.
		 * When a thread enters a synchronized block, it acquires the lock
		 * associated with the object. Other threads must wait until the 
		 * object is released until they can use it. 
		 */
		Object o = new Object();
		int count = 0;
		synchronized (o) {
			/* THis ensures that the `count` variable is synchornized. 
			 * The Object `o` is used as a lock.
			 */
			++count;
		}

	}

	public static void testExecutor () {
		/* What is the executor service? 
		 * A high level way to manage threads. Part of java.util.concurrent. 
		 * The Executor interface defines a single method `execute(Runnable)`.
		 * Submit tasks for exec, exec lifecycle, and getting output.
		 * Thread creation, lifecycle management, and pooling.
		 */
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3 ; i++) {
			System.err.println("Starting: "+i);
			executor.execute(() -> {
				String threadName = Thread.currentThread().getId()+"";
				System.out.println("In Thread ["+threadName+"]");
				try {
					Thread.sleep(1000);
					System.out.println(threadName+" is done.");
					System.out.println("\n");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		
		executor.shutdown();
	}

	/* What is a deadlock? */
}