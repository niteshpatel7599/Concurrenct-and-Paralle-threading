package com.multithreading.producer_consumer_queue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
/*
 * I am adding here for Thread state             -> Completed/Terminated -> Dead
 * -Created -> New ->Started -> Ready -Run ->    
 * 												 -> Scheduling ->Running ->Entering to Non-runnable
 * 													-> Here process is (sleeping or Blocked for join competion
 * 												, Blocked I/O) Waiting for notification -> Blocked for lock Acquistion)
 * That means if adder 1 get locks and added to queue and again queue full adder 2 will go in waiting again
 * and notifyall once from remove method if some item is removed it will notify by the help of notifyAll 
 * method and when adder togot chance it will not go directly to start running it go through 
 * Blocked for lock Acquistion after that it will go to ready to run and completed and other
 * thread will through same process.
 *  
 *  
 */
	Queue<Integer> q;
	private int capacity;
	
	public BlockingQueue(Queue<Integer> q, int capacity) {
		this.q = new LinkedList<>();
		this.capacity = capacity;
	}
	
	public boolean add(int item) {
		synchronized (q) {
			//Why we used while we can use if condition but to check condition
			/*of the queue again after on thread added and if it equal to capacity it will
			 * again go to wait state. i.e we need to use while loop instead of If statement.
			 * 
			 */
			while(q.size() == capacity)
			try {
				q.wait(); //adder1 //adder2 (They are stay in wait set)
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			q.add(item);
			q.notifyAll();
			return true;
		}
	}
	
	public int remove(int item) {
		synchronized (q) {
			while(q.size() == 0) {
				try {
					q.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//Do something 
			int element = q.poll();
			q.notifyAll();
			return element;
					}
	}
	
}
