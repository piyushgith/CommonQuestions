package com.java.collection.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.collection.helper.Employee;

public class ListExample2 {
	public static void main(String[] args) {


	}
	public static void firstMethod() {
		List<Employee> list = Stream.of(new Employee(1, "Ravish", 30), new Employee(1, "Rahul", 30),
				new Employee(2, "Arun", 30), new Employee(3, "Danish", 24), new Employee(4, "Piyush", 20))
				.collect(Collectors.toList());
		list.forEach(System.out::println);

		List<List<String>> namesNested = Arrays.asList(Arrays.asList("Jeff", "Bezos"), Arrays.asList("Bill", "Gates"),
				Arrays.asList("Mark", "Zuckerberg"));

		List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());

		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

		List<Integer> collect = infiniteStream.skip(3).limit(5).collect(Collectors.toList());
	}
	
	public static void Method() {}
}
