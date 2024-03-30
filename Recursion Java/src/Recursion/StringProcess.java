//Author: John Photis
//Purpose: This Java program outputs the the palindrome of a string.

package Recursion;

import java.util.Scanner;

public class StringProcess {
	public static String longestPalindrome(String s) {
		int palindromeLength = 1;
		int index = 0;
		boolean flag;
		for (int i = 0; i < s.length(); i++) { 
			for (int j = i; j < s.length(); j++) { 
				flag = true; 
				for (int x = 0; x < (j - i + 1) / 2; x++) { 
					if (s.charAt(i + x) != s.charAt(j - x)) { 
						flag = false; 
					}
				}
				if (flag == true && palindromeLength < (j - i + 1)) { 
					index = i; 
					palindromeLength = j - i + 1; 
				}
			}
		}
		return s.substring(index, index + palindromeLength); 
	}

	public static void main(String[] args) {
		String s = "cbbc";
		System.out.println(longestPalindrome(s));		
//		Scanner input = new Scanner(System.in);
//        System.out.print("Please enter a string: ");
//        String s = input.nextLine();
//		System.out.println("For String "  + s + " the longest palindrome substring is " + longestPalindromeSubstring(s)); 
	}
}