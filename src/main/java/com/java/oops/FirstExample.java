package com.java.oops;

public class FirstExample {

	public static void main(String args[]) {
		// System.out.println("Hi");
		printFabbonachiNumber(10);
	}

	public static void printFabbonachiNumber(int range) {
		int firstNum = 0;
		int secondNum = 1;
		int temp = 0;
		for (int i = 0; i < range; i++) {
			if (i == 0) {
				System.out.print(firstNum + ", ");
			} else if (i == 1) {
				System.out.print(secondNum + ", ");
			} else {
				temp = firstNum;
				firstNum = secondNum;
				secondNum = secondNum + temp;
				System.out.print(secondNum + ", ");
			}
		}
	}

	public static void pallendrum(int num) {
	}

}
