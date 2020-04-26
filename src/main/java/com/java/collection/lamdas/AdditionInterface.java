package com.java.collection.lamdas;

@FunctionalInterface
public interface AdditionInterface {
	// FI can have only 1 abstract method
	public int add(int i, int j);

	// FI can have default and static method
	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print \t" + str);
	}

	static boolean isNull(String str) {
		System.out.println("Interface Null Check");
		return str == null ? true : "".equals(str) ? true : false;
	}
	//public is default modifier in Interface no need
	//Interface can have multiple static method
    public static int multiply(int a, int b) {
        return a * b;
    }
}
