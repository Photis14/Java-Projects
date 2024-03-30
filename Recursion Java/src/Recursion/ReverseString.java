//Author: John Photis
//Purpose: This Java program outputs the reverse of a string by using recursion.

package Recursion;

import java.util.Scanner;

public class ReverseString {

	  public static void reverseDisplay(String s) {
		  if ((s==null)||(s.length() <= 1))
	           System.out.println(s);
	        else
	        {
	            System.out.print(s.charAt(s.length()-1));
	            reverseDisplay(s.substring(0,s.length()-1));
	        }
	    }

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        System.out.print("Enter a String: ");
	        String s = input.nextLine();
	        System.out.print("The reversed string is: ");
	        reverseDisplay(s);

	    }
	}