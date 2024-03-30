//Author: John Photis
//Purpose: This Java program outputs the sum of	the	digits in an integer using recursion.

package Recursion;

import java.util.Scanner;

public class SumAllDigits {

	public static int sumDigits(int n)
    {
        if (n == 0)
            return 0;
        return (n % 10 + sumDigits(n / 10));
    }
 
    public static void main(String args[]){
    	Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        int n = input.nextInt();
        int result = sumDigits(n);
        System.out.println("The sum of all digits is: " + result);
    }
}
