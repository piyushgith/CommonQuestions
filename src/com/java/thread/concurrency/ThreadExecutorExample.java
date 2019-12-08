package com.java.thread.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExecutorExample {
	//Share same value between multiple threads
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(3);
		Callable<Integer> cMessage = new Message();
		try {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < 3; i++) {
					Future<Integer> f = ex.submit(cMessage);
					System.out.println("Value " + f.get());
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			ex.shutdown();
			System.out.println("Shutting down Executor Service!!");
		}
	}
}

class Message implements Callable<Integer> {

	private volatile int i = 0;

	public Integer call() throws Exception {
		Thread t = Thread.currentThread();
		System.out.println("Id " + t.getId() + " name ==> " + t.getName());
		return ++i;
	}
}
