package com.blit;

public class MyThread extends Thread {
    @Override
    public void run () {
        System.out.println("=======================");
        System.out.println("In a Thread child class");
        System.out.println(Thread.currentThread());
    }
}
