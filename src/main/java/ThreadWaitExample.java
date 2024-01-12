package src.main.java;

import java.util.concurrent.CountDownLatch;

public class ThreadWaitExample {
    public static void main(String[] args) {
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        CountDownLatch latch3 = new CountDownLatch(1);
        CountDownLatch latch4 = new CountDownLatch(1);

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1");
            latch1.countDown();
        });

        Thread thread2 = new Thread(() -> {
            try {
                latch1.await();
                System.out.println("Thread 2");
                latch2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                latch1.await();
                System.out.println("Thread 3");
                latch3.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                latch1.await();
                System.out.println("Thread 4");
                latch4.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                latch2.await();
                System.out.println("Thread 5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread6 = new Thread(() -> {
            try {
                latch3.await();
                System.out.println("Thread 6");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread7 = new Thread(() -> {
            try {
                latch4.await();
                System.out.println("Thread 7");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}