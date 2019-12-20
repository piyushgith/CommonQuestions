package com.java.thread;

public class ThreadExample2 {

	public static void main(String[] args) {
		MyRunnable mRunnable = new MyRunnable();
		Thread t = new Thread(mRunnable);
		t.start();

		// Java 8 Way ==> Correct Way
		// Runnable r = () -> System.out.println("\nImportant job running in a Runnable");//also correct
		Runnable r = () -> {
			for (int x = 1; x < 6; x++) {
				System.out.println("Runnable running " + x);
			}
		};

		Thread t2 = new Thread(r);
		t2.start();

		// or

		Thread t4 = new Thread(() -> System.out.println("\nLamda Important job running in a Runnable"));
		t4.start();

		// can pass same runnable to multiple threads
		Thread foo = new Thread(r);
		Thread bar = new Thread(r);
		Thread bat = new Thread(r);
		//foo.start();
		//bar.start();
		//bat.start();

	}

}

class MyRunnable implements Runnable {

	public void run() {
		// Any Task you want to Execute
		System.out.println("Hi From MyRunnable !!\n");
	}

}
