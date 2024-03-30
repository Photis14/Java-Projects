//Author: John Photis
//Purpose: This Java program removes duplicates in a given string. 

package Stack;

import java.util.*;

public class RemoveDuplicate {
	public static String removeDuplicate(String s) {
		// YOUR CODES
		int i = 0;
		while (i < s.length() - 1) {
			if (s.charAt(i) == s.charAt(i + 1)) {

				s = s.substring(0, i) + s.substring(i + 2);
				i = 0;
			} else {
				i++;
			}
		}
		return s;
	}

	public static void main(String[] args) {
		// YOUR CODES
		// ask the user to enter a string
		// print the string after all two successive duplicate characters
		// removed.
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String s = input.nextLine();
		System.out.print("After removing all adjacent duplicate characters, the string is:  ");
		System.out.println(removeDuplicate(s));
	}
}