//Author: John Photis
//Purpose: This Java program outputs the longest common prefix of the strings the user enters. 



package Loops;

import java.util.Scanner;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the first string: ");
		String firststring = input.nextLine();
		System.out.print("Enter the second string: ");
		String secondstring = input.nextLine();

		int i = 0;				
		String prefix = "";		
		
		while (firststring.charAt(i) == secondstring.charAt(i)) {
			prefix += firststring.charAt(i);
			i++;
		}

		if (prefix.length() > 0)
			System.out.println("The longest commmon prefix is: " + prefix);
	}

}
