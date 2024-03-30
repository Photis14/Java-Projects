//Author: John Photis
//Purpose: This Java program outputs the minimum length of a runway for an airplane.


package Conversions;

import java.util.Scanner;

public class RunwayLength {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("$ java RunwayLength");
		
		System.out.print("Enter the velocity in meters/second: ");
        double velocity = input.nextDouble();
        System.out.print("Enter the acceleration in meters/second squared: ");
        double acceleration = input.nextDouble();

        double length = (velocity * velocity) / (2 * acceleration);
        
        System.out.printf("The minimum runway length for this airplane is: %.2f meters", length);

	}

}
