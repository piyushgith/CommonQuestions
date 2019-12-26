package com.java.datetime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeExample1 {

	public static void main(String[] args) {
		// New Date Api
		LocalDate lDate = LocalDate.now();
		System.out.println("Java 8 LocalDate : " + lDate);

		ZonedDateTime zonedDateTime = ZonedDateTime.now();// Asia/Calcutta

		ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("Java 8 ZonedDateTime LocalTime : " + zonedDateTime);

		System.out.println("Java 8 ZonedDateTime NewYork_Time : " + zonedDateTime1);
		System.out.println();

	}

}
