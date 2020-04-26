package com.java.oops;

class SuperClass implements Cloneable {
	int i = 10;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// Singleton class 
class SingletonExample extends SuperClass {
	// public instance initialized when loading the class
	public static SingletonExample instance = new SingletonExample();

	private SingletonExample() {
		// private constructor
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return instance;
	}
	
	/* Or 
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}*/
}

public class Singleton1 {

	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonExample instance1 = SingletonExample.instance;
		SingletonExample instance2 = (SingletonExample) instance1.clone();
		System.out.println("instance1 hashCode:- " + instance1.hashCode());
		System.out.println("instance2 hashCode:- " + instance2.hashCode());
	}

}
