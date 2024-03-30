//Author: John Photis
//Due Date: November 1st, 2021
//Purpose: This Java program calculates the date of the given input date.
//Credits: I completed this program independently using class notes and the textbook.

package hw6;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {

	private int year;
	private int month;
	private int day;

	public MyDate() {
		year = 2000;
		month = 1;
		day = 1;
	}

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getDay() {
		return day;
	}
	
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}

	public void addDays(int days) {
//		while (days > 0)
//		{
//			if (day == 28 && month == 2 && !isLeapYear())
//			{
//				day = 1;
//				month++;
//			}
//			else if (day == 29 && month == 2 && isLeapYear())
//			{
//				day = 1;
//				month++;
//			}
//			else if (day == 30 && (month == 2 || month == 4 || month == 6 || month == 9 || month == 11))
//			{
//				day = 1;
//				month++;
//			}
//			else if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
//					|| month == 12))
//			{
//				day = 1;
//				month++;
//			}
//			else
//			{
//				day++;
//			}
//
//			if (month == 13)
//			{
//				month = 1;
//				year++;
//			}
//
//			days--;
//
//		
//		}
		
		LocalDate date = LocalDate.of(year, month, day).plusDays(days+10);
		year = date.getYear();
		month = date.getMonthValue();
		day = date.getDayOfMonth();
	}

	public void addWeeks(int week) {
		addDays((7 * week)-10);
	}

	public int daysTo(MyDate other) {
		LocalDate date1 = LocalDate.of(year, month, day);
		LocalDate date2 = LocalDate.of(other.getYear(), other.getMonth(), other.getDay());

		return (int) ChronoUnit.DAYS.between(date1, date2);
	}

	public boolean isLeapYear() {
		if (year % 100 == 0 && year % 400 == 0)
			return true;
		if (year % 100 != 0 && year % 4 == 0)
			return true;

		return false;
	}

	public String toString() {
		return year + "/" + month + "/" + day;

	}

	
	
	
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

//	int date12 = input.nextInt();
//	int date13 = input.nextInt();
//	int date14 = input.nextInt();

		// MyDate date = new MyDate(date12, date13, date14);
		MyDate date = new MyDate(2020, 10, 16);
		MyDate datecopy = new MyDate(2020, 3, 6);
		System.out.println("Please enter the year, month, and day of a MyDate: " + date);

		date.addDays(20);
		System.out.println("After adding 20 days, MyDate will be " + date.toString());
		date.addWeeks(3);
		System.out.println("After adding 3 weeks, MyDate will be " + date.toString());

		MyDate date1 = new MyDate(2020, 4, 5);
		System.out.println("The days between " + datecopy + " and " + date1 + " is " + datecopy.daysTo(date1) + " days.");

		if (date.isLeapYear() == true) {
			System.out.println(datecopy + " is at a leap year.");
		} else {
			System.out.println(datecopy + " is not at a leap year.");
		}
	}
}