package com.java.collection;

import java.util.List;
import java.util.Set;

import com.java.collection.helper.Employee;

public class CollectionExample {

	public static void main(String[] args) {

		List<Employee> list = Employee.getEmployeeList();
		//list.forEach(System.out::println);

		Set<Employee> set = Employee.getEmployeeSet();
		set.forEach(System.out::println);
	}

}
