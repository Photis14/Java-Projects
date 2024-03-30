//Author: John Photis
//Purpose: This Java program outputs Fibonacci by using both iteration and recursion.

package Recursion;

import java.util.Scanner;

public class ComputeFibonacci {
	public static int count=0;
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int number = input.nextInt();

		System.out.println("\nThe first 7 numbers in the Fibonacci sequence using iteration is: ");
		System.out.print(0 + " ");
		for (int i = 1; i < number; i++) {
			System.out.print(fibIterative(i) + " ");
		}
    	System.out.println("\n\nThe first 7 numbers in the Fibonacci sequence using recursion is: ");
		System.out.print(0 + " ");
		for (int i = 1; i < number; i++) {
			System.out.print(fibRecursive(i) + " ");

		}
		System.out.print(recursiveCalling(number));
		//System.out.println("\n\nTo compute for Fibonacci number for " + number + ", you need to call the fibRecursive method " + count + " times");
	}

	public static int fibIterative(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for (int i = 3; i <= n; i++) {
			fibonacci = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibonacci;

		}
		return fibonacci;
	}
	public static int fibRecursive(int n) {
		count++;
		  if(n == 0){
		       return 0;
		   }
		   if(n == 1 || n == 2){
		           return 1;
		       }
		   return fibRecursive(n-2) + fibRecursive(n-1);
		   }
	
	public static String recursiveCalling(int number) {
		String s="\n\nTo compute for Fibonacci number for " + number + ", you need to call the fibRecursive method " + count + " times";
		return s;
	}
}
	