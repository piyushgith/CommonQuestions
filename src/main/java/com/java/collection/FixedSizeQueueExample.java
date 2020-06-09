package com.java.collection;

import org.apache.commons.collections4.queue.CircularFifoQueue;

public class FixedSizeQueueExample {

	public static void main(String[] args) {
		System.out.println("hi");
		
		
		CircularFifoQueue<String> colors = new CircularFifoQueue<>(2);
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.offer("White");
		colors.offer("Black");
		String colorsHead = colors.peek();
		colorsHead = colors.element();
		colorsHead = colors.remove();
		colors.poll();
		colors.forEach(System.out::println);
	}
	
}
