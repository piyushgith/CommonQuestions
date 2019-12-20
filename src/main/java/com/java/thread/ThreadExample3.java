package com.java.thread;

public class ThreadExample3 {

	public static void main(String[] args) {
		WaitandNotify wNotify = new WaitandNotify();
		Thread t = new Thread(wNotify);
		t.start();

		// synchronized block to perform some operation
		synchronized (t) {
			try {
				System.out.println("Before Wait !!");
				t.wait();
				System.out.println("After Wait !!");
			} catch (InterruptedException e) {
				System.err.println("Exception Happened !!");

			}
		}

	}

}

class WaitandNotify implements Runnable {

	public void run() {
		try {
			Thread.sleep(1000);
			// Any Task you want to Execute
			//wait,notify,notifyAll() must be called from synchronized block
			synchronized (this) {
				System.out.println("\nHi From MyRunnable !!\n");
				notify();
			}
			//notify();//==> Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

	}

}