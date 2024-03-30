//Author: John Photis
//Due Date: October 18th, 2021
//Purpose: This Java program outputs a linear and binary search.
//Credits: I completed this program independently using class notes and the textbook. 


package MoreArrays;

import java.util.*;

public class ExecutionTime {

	public static int[] getData() {
		int[] arr = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1000) + 1;
		}
		return arr;
	}

	public static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return low;
			}
			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	public static final Random random = new Random();
	
	public static void main(String[] args) {
		int[] arr = getData();
		
		int target = random.nextInt(1000) + 1;
		
		int index = linearSearch(arr, target);
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Linear search found item at index= " + index);
		System.out.println("Execution time for linear search: " + executionTime + " milliseconds.");
		System.out.println();

		Arrays.sort(arr);
		
		index = binarySearch(arr, target);
		startTime = System.currentTimeMillis();
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Binary search found item at index= " + index);
		System.out.println("Execution time for binary search: " + executionTime + " milliseconds.");
		System.out.println();

	}

}
