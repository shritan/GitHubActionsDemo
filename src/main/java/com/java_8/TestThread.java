package com.java_8;

public class TestThread {

    public static void main(final String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread = new MyThread();
        myThread.start();
        myThread = new MyThread();
        myThread.start();
        myThread = new MyThread();
        myThread.start();
        final MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("My Thread Class " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("My Thread Intreface " + Thread.currentThread().getName());

    }

}
