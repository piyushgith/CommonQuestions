package com.java.thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadExample4 {
	// Producer Consumer Example
	// BlockingQueue Example
	public static void main(String[] args) {
		int maxSize = 10;
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

		Thread producer = new Thread(new Producer(sharedQueue, maxSize), "Producer-Thread");
		Thread consumer = new Thread(new Consumer(sharedQueue, maxSize), "Consumer-Thread");
		// THis will run infinite
		producer.start();
		consumer.start();
	}

}

class Producer implements Runnable {

	private BlockingQueue<Integer> queue;
	private int maxSize;

	public Producer(BlockingQueue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			// queue is common object passing in between threads
			synchronized (queue) {
				while (queue.size() == maxSize) {// check if it is full
					try {
						System.out.println("Queue is full");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// Now Insert the value. It comes under sync block.
				Random random = new Random();
				int number = random.nextInt(100);
				System.out.println("Producing value " + number);
				queue.add(number);
				queue.notify();
			}
		}
	}

}

class Consumer implements Runnable {

	private BlockingQueue<Integer> queue;
	private int maxSize;

	public Consumer(BlockingQueue<Integer> queue, int maxSize) {
		super();
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is Empty");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// Just to reduce consumption speed
				try {
					Thread.sleep(1000);
					int number = (int) queue.poll();
					System.out.println("Removing Element " + number);
					queue.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

}