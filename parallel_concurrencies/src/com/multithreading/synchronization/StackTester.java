package com.multithreading.synchronization;

public class StackTester {

	public static void main(String[] args) {
		
		Stack stack = new Stack(5);
		new Thread(() ->{
			int counter=0;
			while(++counter < 10) {
				System.out.println("Pusher" + stack.push(100));
			}
		},"Pusher").start();
		new Thread(() ->{
			int counter =0;
			while(++counter <10) {
				System.out.println("Popped" +stack.pop());
			}
		}, "Popper").start();
		System.out.println("main thread existing");
	}
}
