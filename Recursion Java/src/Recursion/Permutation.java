//Author: John Photis
//Purpose: This Java program outputs the sum of	the	digits in an integer using recursion.

package Recursion;

import java.util.Scanner;

public class Permutation {

	public static void displayPermuation(String s) {
        displayPermuation("", s);
    }

    public static void displayPermuation(String s1, String s2) {
        if(s2.isEmpty()) {
            System.out.println(s1);
        } else {
            for(int i = 0; i < s2.length(); ++i) {
                displayPermuation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i+1));
            }
        }
    }


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String s = input.nextLine();
        System.out.print("All permuation of this string would be: \n");
        Permutation.displayPermuation(s);
	    }
	}


