//Author: John Photis
//Purpose: This Java program sorts through the odd-even	method.

package Stack;

import java.util.*;

public class OddEvenSort {
	public int[] sort(int[] arr) {
		// YOUR CODES
		int temp;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int j = 1; j <= arr.length - 2; j += 2) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					sorted = false;
				}
			}
			for (int j = 0; j <= arr.length - 2; j += 2) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					sorted = false;
				}
			}
		}
		return arr;

	} // For compilation. You need to change it.

	public static void main(String[] args) {
		OddEvenSort oddEvenSort = new OddEvenSort();
		int[] arr0 = {};
		System.out.println("The original array is:");
		System.out.println(Arrays.toString(arr0));
		System.out.println("After sorting, the array is:");
		int[] results = oddEvenSort.sort(arr0);
		System.out.println(Arrays.toString(results) + "\n");

		int[] arr1 = { -1, 0, 100, 20, 0, 0, -2, 10, 12 };
		System.out.println("The original array is:");
		System.out.println(Arrays.toString(arr1));
		System.out.println("After sorting, the array is:");
		results = oddEvenSort.sort(arr1);
		System.out.println(Arrays.toString(results) + "\n");

		int[] arr2 = { 20, 18, 16, 14, 12, 10, 8, 6, 4, 2, 0 };
		System.out.println("The original array is:");
		System.out.println(Arrays.toString(arr2));
		System.out.println("After sorting, the array is:");
		results = oddEvenSort.sort(arr2);
		System.out.println(Arrays.toString(results) + "\n");

		int[] arr3 = { 3, 4, 0, 5, 9, 20, 15, 14, 17, 24, 56, 0, 0, 1 };
		System.out.println("The original array is:");
		System.out.println(Arrays.toString(arr3));
		System.out.println("After sorting, the array is:");
		results = oddEvenSort.sort(arr3);
		System.out.println(Arrays.toString(results) + "\n");
	}
}