//Author: John Photis
//Purpose: This Java program outputs the roots of any input if they exist.


 
package Math;

import java.util.Scanner; 

public class QuadraticRoot {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);  
		
		System.out.print("Enter the value of a, b, c: ");  
		
		double a = input.nextDouble();   
		
		double b = input.nextDouble();   
		
		double c = input.nextDouble();  
		
		double discriminant= b * b - 4.0 * a * c;  
		
		if (discriminant> 0.0)   
		{  
		double r1 = (-b + Math.pow(discriminant, 0.5)) / (2.0 * a);  
		double r2 = (-b - Math.pow(discriminant, 0.5)) / (2.0 * a);  
		System.out.println("The equation has two roots: " + String.format("%.6f",r1) + " and " + String.format("%.6f",r2));    
		}   
		else if (discriminant == 0.0)   
		{  
		double r1 = -b / (2.0 * a);  
		System.out.println("The equation has one root: " + r1);  
		}   
		else   
		{  
		System.out.println("The equation has no real roots.");  

	}

	}
}
