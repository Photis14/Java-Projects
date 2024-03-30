//Author: John Photis
//Purpose: This Java program outputs the distance between two points the user inputs.
 

package Conversions;

import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		
        System.out.println("$ java Distance");
       
    	 
         double distance;

         Scanner input = new Scanner (System.in);

         System.out.println("Please enter x1 and y1: ");
   
         double x1 = input.nextDouble();
 		double y1 = input.nextDouble();
             
         System.out.println("Please enter x2 and y2: ");
         
         double x2 = input.nextDouble();
 		 double y2 = input.nextDouble();
         
  	    
 		 distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	 	    	 	    
	     System.out.println("The distance between these two points is: " + String.format("%.2f",distance));

	}

}
