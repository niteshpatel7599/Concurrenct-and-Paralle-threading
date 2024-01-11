package com.multithreading.producer_consumer_queue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

	Queue<Integer> q;
	private int capacity;
	
	public BlockingQueue(Queue<Integer> q, int capacity) {
		this.q = new LinkedList<>();
		this.capacity = capacity;
	}
	
	public boolean add(int item) {
		synchronized (q) {
			if(q.size() == capacity)
			//do something here
			q.add(item);
			q.notifyAll();
			return true;
		}
	}
	
	public int remove(int item) {
		synchronized (q) {
			if(q.size() == 0) {
				try {
					q.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//Do something 
			int element = q.poll();
			return element;
					}
	}
	
}
