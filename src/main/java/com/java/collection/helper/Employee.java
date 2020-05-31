package com.java.collection.helper;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1922861804046026278L;

	private int id;
	private String name;
	private int age;

	public static List<Employee> getEmployeeList() {
		return Stream.of(new Employee(1, "Ravish", 30), new Employee(1, "Rahul", 30), new Employee(2, "Arun", 30),
				new Employee(3, "Danish", 24), new Employee(4, "Piyush", 20)).collect(Collectors.toList());
	}

	public static Set<Employee> getEmployeeSet() {
		return Stream.of(new Employee(1, "Ravish", 30), new Employee(1, "Rahul", 30), new Employee(2, "Arun", 30),
				new Employee(3, "Danish", 24), new Employee(4, "Piyush", 20)).collect(Collectors.toSet());
	}

	public Employee() {
		super();
	}

	public Employee(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
