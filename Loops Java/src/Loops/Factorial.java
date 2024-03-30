//Author: John Photis
//Purpose: This Java program outputs the factorial of a number the user enters. 


package Loops;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Please enter a number: ");
		
		
		int num = input.nextInt();
		long factorial = 1;
        
		
		//for loop
		for(int i = 1; i <= num; ++i)
        {
            factorial *= i;
        }
        System.out.println("The factorial of " + num + " is (for-loop): " + factorial); 

        
        int i = 1;
        factorial = 1;
        
        //while loop
        while(i <= num)
        {
            factorial *= i;
            i++;
        }
        System.out.println("The factorial of " + num + " is (while-loop): " + factorial);
	}

}
