//Author: John Photis
//Purpose: This Java program outputs the volume of an Ellipsoid.


package Conversions;

public class EllipsoidVolume {

	public static void main(String[] args) {
		
		double a = 10.5;
		double b = 8.6;
		double c = 5.7;

		final double PI = Math.PI; 
		
		double volume = (4.0/3.0 * PI * a * b * c);
		
		System.out.println("$java EllipsoidVolume");
		System.out.println(String.format("The volume for the Ellipsoid with axis 10.5, 8.6 and 5.7 is: %.2f", volume));
		
	}

}
