//Author: John Photis
//Due Date: September 20th, 2021
//Purpose: This Java program outputs the conversion of feet to meters.
//Credits: I completed this program independently using class notes and the textbook. 

package Conversions;

import java.util.Scanner;

public class FeetToMeters {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		  
		 System.out.println("$ java FeetToMeters");
		 double feet;
		 double meter;
		 
		 System.out.println("Enter a value for feet: ");
		 feet = input.nextDouble();
		 meter = feet * 0.305;
		 System.out.println(feet + " is " + String.format("%.2f", meter) + " meters ");
				 
		 
		 
	}

}

