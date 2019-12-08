package com.java.thread;

public class ThreadExample1 {
	//old way not good
	public static void main(String[] args) {
		MessageThread mThread = new MessageThread();
		mThread.start();
	}
}

class MessageThread extends Thread {

	@Override
	public void run() {
		System.out.println("Hi There from Message");
	}

}