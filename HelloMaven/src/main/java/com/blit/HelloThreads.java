package com.blit;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Runnable;


public class HelloThreads {
    public HelloThreads () {
        System.out.println(Thread.currentThread() + " is the main thread.");
    
        Thread t1 = new MyThread();
        t1.run(); // run in main
        t1.start(); // ram o
        System.out.println("Showning out of order");
        
        Thread t2 = new Thread(() -> {
            System.out.println("In a runnable thread.");
            System.out.println(Thread.currentThread());
            
        });
    
        t2.start();
        new MyThread().start();
    
        // Executor.
        // Creates 3 threads that will be utilized.
        ExecutorService exec = Executors.newFixedThreadPool(3);
        
        exec.execute(() -> {  
            System.out.println(Thread.currentThread());
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        exec.execute(() -> {
            System.out.println("In a executor thread.");
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Deadlock
        HelloThreads ht1 = new HelloThreads();
        HelloThreads ht2 = new HelloThreads();

        t1 = new Thread(() -> {
            
        });

        
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

} 
