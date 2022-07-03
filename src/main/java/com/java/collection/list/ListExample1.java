package com.java.collection.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListExample1 {

	public static void main(String[] args) {

		Vector<String> listC = new Vector<>();
		Stack<String> listD = new Stack<>();

		listC.add("Hello");
		listC.add("World");
		listC.add("Piyush");

		// listC.forEach(System.out::println);

		listD.add("Hello");
		listD.add("World");
		listD.add("Piyush");

		// listD.

		listD.forEach(System.out::println);

	}

	public static void firstMethod() {
		List<String> listA = new ArrayList<>();
		List<String> listB = new LinkedList<>();
	}

	public static void secondMethod() {
		List<String> items = new ArrayList<>();

		items.add("one");
		items.add("two");
		items.add("three");

		Stream<String> stream = items.stream();

		List<String> filtered = items.stream().filter(item -> item.startsWith("o")).collect(Collectors.toList());

		String shortest = items.stream().min(Comparator.comparing(item -> item.length())).get();

		long count = items.stream().filter(item -> item.startsWith("t")).count();

		String reduced2 = items.stream().reduce((acc, item) -> acc + " " + item).get();
	}

	public static void thirdMethod() {

	}
}
