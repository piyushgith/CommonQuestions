package com.java.thread.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyExample3 {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		ReentrantLockMethodsCounter lockMethodsCounter = new ReentrantLockMethodsCounter();

		Callable<Integer> callable = () -> { return lockMethodsCounter.incrementAndGet(); };

		Future<Integer> f1 = executorService.submit(callable);

		//or

		try {
			System.out.println("future.get() = " + f1.get());
			
			executorService.submit(() -> {
				System.out.println("IncrementCount (First Thread) : " + lockMethodsCounter.incrementAndGet() + "\n");
			});
			
			executorService.submit(() -> {
	            System.out.println("IncrementCount (Second Thread) : " +lockMethodsCounter.incrementAndGet() + "\n");
	        });
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}		
		
	}
}

class ReentrantLockMethodsCounter {
	private final ReentrantLock lock = new ReentrantLock();

	private int count = 0;

	public int incrementAndGet() {
		System.out.println("Thread Id: " + Thread.currentThread().getId());
		// Check if the lock is currently acquired by any thread
		System.out.println("IsLocked : " + lock.isLocked());

		// Check if the lock is acquired by the current thread itself.
		System.out.println("IsHeldByCurrentThread : " + lock.isHeldByCurrentThread());

		// Try to acquire the lock
		boolean isAcquired = false;
		try {
			isAcquired = lock.tryLock(1, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Lock Acquired : " + isAcquired + "\n");

		if (isAcquired) {
			try {
				Thread.sleep(2000);
				count = count + 1;
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			} finally {
				lock.unlock();
			}
		}
		return count;
	}
}