package com.java.string;

public class StringExample {

	public static void main(String[] args) {

		stringMethods("Hello World, Lets check string methods");

	}

	public static void stringMethods(String str) {
		System.out.println(str.toUpperCase());
		System.out.println(str.substring(0, str.length() - 8));
		System.out.println("Index of ',' : " + str.indexOf(','));
		reverse(str);

	}

	public static void reverse(String str) {
		char[] cArray = str.toCharArray();
		for (int i = 0; i < cArray.length / 2; i++) {
			// System.out.println(cArray[i]);
			char temp = cArray[i];
			cArray[i] = cArray[cArray.length - i - 1];
			cArray[cArray.length - i - 1] = temp;
		}
		// cArray.toString() will not work
		System.out.println(new String(cArray));
		//Another Way reverse method of StringBuffer
	}

}