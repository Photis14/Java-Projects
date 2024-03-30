//Author: John Photis
//Purpose: This Java program outputs whether an array is already sorted	in non-descending order	or not.




package Arrays;

import java.util.Scanner; 

public class SortOrNot {

	public static boolean isSorted(int arr[]) 
	{
		for (int i = 1; i < 5; i++) 
			if (arr[i - 1] > arr[i]) 
				return false; 
				return true; 
	}

	public static void display(int arr[])
	{
		System.out.print("The array is: ");
		for (int i = 0; i < 5; i++) 
		{
			System.out.print(" " + arr[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int arr[] = new int[5]; 
		System.out.println("The array is: ");
		for (int i = 0; i < 5; i++) 
			arr[i] = sc.nextInt();  
		boolean sorted = isSorted(arr); 
		if (sorted == true) 
			System.out.println("The array is sorted non-descendingly");
		else
			System.out.println("The array is not sorted non-descendingly");
		
		
		

	}

}
