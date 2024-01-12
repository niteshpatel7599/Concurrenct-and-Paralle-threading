package com.multithreading.deadlock;

public class DeadLockExample {

	public static void main(String[] args) {

		System.out.println("Main is starting");

		String lock1 = "nitesh";
		String lock2 = "patel";
		Thread thread1 = new Thread(() -> {
			synchronized (lock1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("Lock Acquired");
				}
			}
		}, "thread1");

		Thread thread2 = new Thread(() -> {
			synchronized (lock1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("Lock Acquired");
				}
			}
		}, "thread2");
		
		thread1.start(); thread2.start();
	}
}
