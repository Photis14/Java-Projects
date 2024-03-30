//Author: John Photis
//Purpose: This Java program outputs the estimated value of pi.


package Arrays;

import java.util.Scanner;

public class EstimatePI {

	public static double estimate(int num) {
		double pi = 0;
		for(double i = 1; i <= num; i++) {
			pi += Math.pow(-1, i +1)/(2 * i - 1);
		}
		return pi*4;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        
		System.out.print("Please enter an integer: ");
        
        int num = input.nextInt();
        
        double PI=estimate(num);
        
        System.out.println("The estimated value of pi is: " + PI);
		
		
	}		
}

