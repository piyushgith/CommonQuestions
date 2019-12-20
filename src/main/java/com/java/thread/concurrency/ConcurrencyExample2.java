package com.java.thread.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyExample2 {
	// Note that with Callable, you don’t need to surround Thread.sleep() by a
	// try/catch block, because unlike Runnable, Callable can throw a checked exception.
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

		// Define a Callable FI
		Callable<Integer> callableObj = () -> {
			int result = integers.stream().mapToInt(i -> i.intValue()).sum();// sum the list
			return result;
		};

		// Define Executor
		ExecutorService service = Executors.newSingleThreadExecutor();

		Future<Integer> future = service.submit(callableObj); // only future can hold it

		Integer result = 0;

		try {
			result = future.get();
			System.out.println("future.get() = " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}

		System.out.println("Sum = " + result);
	}

}
