package com.java.collection.lamdas;

class Demo implements AdditionInterface {

	@Override
	public int add(int i, int j) {

		return i + j;
	}

}

public class LamdaExample1 {

	public static void main(String[] args) {
		AdditionInterface aI = new Demo();
		aI.print("Hi Piyush !!");

		int result = AdditionInterface.multiply(2, 3);
		System.out.println("Multilication Result : " + result);
		System.out.println("STring Test Result : " + AdditionInterface.isNull("Test"));

		System.out.println("Concrete class Example:   Sum of two value " + aI.add(10, 11));

		// With Lamda Experssion
		// We use Lamda so we don't need concrete class or overriding abstract method
		AdditionInterface aLamda = (int a, int b) -> {
			return a + b;
		};

		System.out.println("Lamda Expression Example: Sum of two value " + aLamda.add(100, 11));

	}

}
