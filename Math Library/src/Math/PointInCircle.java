//Author: John Photis
//Purpose: This Java program outputs the result if the input points are in the circle.



package Math;

import java.util.Scanner; 

public class PointInCircle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

	    System.out.println("Please enter the two coordinates of a point:");
	    
	    double y1 = scanner.nextDouble();
	    double x1 = scanner.nextDouble();


	    double y2 = 0;
	    double x2 = 0;

	    double radius = 10;

	    double distance = Math.pow( x2 - x1, 2) + Math.pow(y2 - y1, 2);

	    distance = Math.sqrt(distance);

	    if(distance < radius) {
	    	System.out.println("Point " + "(" + y1 + " , " + x1 + ")" + " is in the circle.");
	    }
	    else if(distance > radius) {
	    	System.out.println("Point " + "(" + y1+ " , "+ x1 + ")" + " is not in the circle.");
	    }


	}

}
