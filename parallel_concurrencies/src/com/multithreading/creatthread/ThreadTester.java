package com.multithreading.creatthread;

public class ThreadTester {

	public static void main(String[] args) {
		
		System.out.println("Main is starting");
		/*Why there are two ways to create thread in Java Mulit-threading?
		 * 
		 * As Below intansitiation is through extending thread class
		 * What is happening here is Thread class is having run() method while extending it
		 * With our own custom thread class we are using overriding principle means while parent class
		 * method is overridden by child class child class method will executed.
		 * 
		 * Runnable interface is having one abstract method
		 * Here target is refrence of Runnable interface means (Object)
		 *   @Override
    			public void run() {
        			if (target != null) {
            			target.run();
        }
    }
    		Both are doing the same thing no difference. But which one to use while creating a thread?
    		- So Thread is class if we extends we can not extends multiple classes in java on the 
    		other hand we can implenmented as many interface in java.
    		So best way is to use Runnable interface here.
		 */
//		Thread1 thread1 = new Thread1("thread 1");
//		thread1.setDaemon(true);
//		thread1.start();
		/*
		 * We are using lambada here as Runnable is a functional interface which will contains
		 * only one abstract method.
		 */
		Thread thread2 = new Thread(() ->{
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread() + " ,"+ i);
			}
		}, "Thread 2");
		thread2.start();
		System.out.println("Main is existing");
		
	}
}

