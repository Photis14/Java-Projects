//Author: John Photis
//Purpose: This Java program outputs the gratuity and total.


package Conversions;

import java.util.Scanner;

public class Tips {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("$ java Tips");
		
		System.out.print("Please enter the subtotal and a gratuity rate: ");
		double subtotal = input.nextDouble();
		double gratuityrate = input.nextDouble();

		double gratuity = subtotal * (gratuityrate / 100);
		double total = subtotal + gratuity;

		System.out.println("The gratuity if $" + String.format("%.2f", gratuity) + " and total is $" + String.format("%.2f",total));

	}

}
