//Author: John Photis
//Purpose: This Java program outputs the distinct numbers of 10 input numbers.


package MoreArrays;

import java.util.*;

public class DistinctNumbers {

	public static int[] getDistinctNumber() {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[10];
		int num= 0; 
		int count = 0;
		boolean distinct;

		System.out.print("Please enter 10 numbers: ");
		
		for (int i = 0; i < arr.length; i++) {
			num = input.nextInt();
			distinct = true;
		
		for (int j = 0; j < count; j++) {
			if (arr[j] == num) {
					distinct = false;
					break;
				}
			}

			if (distinct)
				arr[count++] = num;
		}

		int[] arraycopy = new int[count];
		for (int i = 0; i < count; i++) {
			arraycopy[i] = arr[i];
		}

		return arraycopy;
	}

	public static void main(String[] args) {
		int[] arr = getDistinctNumber();
		
		System.out.println("There are " + arr.length + " distinct numbers.");
		System.out.print("They are: ");
		
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}

}
