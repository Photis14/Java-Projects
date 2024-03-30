//Author: John Photis
//Purpose: This Java program outputs the shipping cost of the inputed weight. 



package Math;

import java.util.Scanner; 

public class CostOfShipping {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.print("Please enter the weight of package: ");
	    
		double weight = input.nextDouble();
		
		if (weight > 50)
			System.out.println("The package cannot be shipped because it is over 50lbs.");
		else
		{
			double cost; 
			if (weight > 0 && weight <= 1)
				cost = 3.5;
			else if (weight <= 3)
				cost = 5.5;
			else if (weight <= 10)
				cost = 8.5;
			else
				cost = 10.5;
			System.out.println("The cost of the shipping would be: $" + cost + " dollars.");
		
	}
	}
}
