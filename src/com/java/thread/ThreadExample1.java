package com.java.thread;

public class ThreadExample1 {

	public static void main(String[] args) {
		// old way not good
		MessageThread mThread = new MessageThread();
		mThread.start();
		
		// old way for multiple Threads
		try {
			new ThreadExample1().multipleThreads(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void multipleThreads(int argsize) throws InterruptedException {
		//First Create Thread array
		Thread myThreads[] = new Thread[argsize];
		
		//Initialise and start the thread
		for (int j = 0; j < argsize; j++) {
			myThreads[j] = new Thread(new MultiThreadExample(j));
			myThreads[j].start();
		}
		
		//Then join them ==> not needed
		for (int j = 0; j < argsize; j++) {
			//myThreads[j].join();
		}
	}
}

class MessageThread extends Thread {
	@Override
	public void run() {
		System.out.println("Hi There from MessageThread!!");
	}
}

class MultiThreadExample extends Thread {
	private final int i;

	public MultiThreadExample(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println(i+" Hi There from MultiThreadExample !!!!");
	}

}
