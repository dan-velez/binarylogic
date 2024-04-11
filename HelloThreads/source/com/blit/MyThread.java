package com.blit;

public class MyThread extends Thread {
    /* Need to override run to make it a Thread.
     * All threads are running independantly. Cannot forcast which one
     * will output before another. If an exception occurs in a thread,
     * the others will continue.
    */

    private int threadNum;

    @Override
    public void run () {
        for (int i = 1; i <= 5; i++) {
            System.out.println("T:"+this.threadNum+": "+i+", ");
            if (this.threadNum == 3) throw new RuntimeException();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public MyThread (int threadNum) {
        this.threadNum = threadNum;
    }
}

