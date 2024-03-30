//Author: John Photis
//Purpose: This Java program outputs a pyramid of integers. 



package Loops;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.print("Please enter an integer from 1 to 15: ");
		int numberOfLines = input.nextInt();

		//for loop
		for (int rows = 1; rows <= numberOfLines; rows++) {
			for (int s = numberOfLines - rows; s >= 1; s--) {
				System.out.print("  ");
			}
			for (int l = rows; l >= 2; l--) {
				System.out.print(l + " ");
			}
			for (int r = 1; r <= rows; r++) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
		//while loop
			int rows = 1;
			while ( rows <= numberOfLines) {
				int s = numberOfLines - rows;
				int l = rows;
				int r = 1;
				rows++;
				while ( s >= 1 ) {
					System.out.print("  ");
					s--;
					
				}
				while ( l >= 2 ) {
					System.out.print(l + " ");
					l--;
				}
				while ( r < rows ) {
					System.out.print(r + " ");
					r++;
				}
				System.out.println();
			
			
			
		}
	}
}
