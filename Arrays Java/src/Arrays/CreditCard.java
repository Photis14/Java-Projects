//Author: John Photis
//Purpose: This Java program outputs whether or not a credit card number is valid. 

package Arrays;

import java.util.*;

public class CreditCard {

	   public static boolean isValid(String number) {
	       if (getSize(number) >= 13 && getSize(number) <= 16) {
	           if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) {
	               if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
	                   return true;
	               }
	           }
	       }
	       return false;
	   }


	   public static int sumOfDoubleEvenPlace(String number) {
	       String[] arr = number.split("");
	       int sum = 0;
	       for (int i = number.length() - 2; i >= 0; i -= 2) {
	           int temp = 2 * Integer.parseInt(arr[i]);
	           sum += getDigit(temp);
	       }
	       return sum;
	   }


	   public static int getDigit(int number) {
	       if (number >= 10) {
	           String str = Integer.toString(number);
	           String[] arr = str.split("");
	           int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
	           return sum;
	       }
	       return number;
	   }

	   public static int sumOfOddPlace(String number) {
	       String[] arr = number.split("");
	       int sum = 0;
	       for (int i = number.length() - 1; i >= 0; i -= 2) {
	           sum += getDigit(Integer.parseInt(arr[i]));
	       }
	       return sum;
	   }

	   public static boolean prefixMatched(String number, int d) {
	           return true;
	   }

	   public static int getSize(String number) {
	       return number.length();
	   }

	   public static long getPrefix(String number, int k) {
	       String c = "";
	       for (int i = 0; i < k; i++) {
	           c += number.charAt(i);
	       }
	       return Long.parseLong(c);
	   }

	   public static void main(String[] args) {
	       Scanner input = new Scanner(System.in);
	       
	       System.out.println("Please enter a credit card number as a string: ");
	       
	       String number = input.nextLine();
	      
	       if (isValid(number))
	           System.out.println(number + " is valid.");
	       else
	           System.out.println(number + " is NOT valid.");
	
	
	
	
	
	
	
	
	
	}
		
}
