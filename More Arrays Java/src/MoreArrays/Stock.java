//Author: John Photis
//Purpose: This Java program outputs the maximum profits of an array.


package MoreArrays;

import java.util.*;

public class Stock {
	
	public static int[] getData() {
		Scanner input = new Scanner(System.in);

		int n = 10;
		int[] arr = new int[n];
		System.out.print("Please enter 10 numbers: ");
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}

		return arr;

	}

	public static int maxProfit(int[] arr){
		int maxprofit = 0;
		for (int i = 1; i < arr.length; i++){
			if (arr[i] > arr[i - 1]){
				maxprofit += arr[i] - arr[i - 1];
			}
		}

		return maxprofit;
	}

	public static void main(String[] args) {

		int[] arr = getData();

		int maxprofit = maxProfit(arr);
		
		int a = arr[2] - arr[arr.length-1];
		
		int b = arr[4] - arr[3];
		
		int c = arr[arr.length-1] + arr[3];

		System.out.println("The array is: " + Arrays. toString(arr));
		
		System.out.println("The maximum profit is: " + maxprofit);
		
		System.out.println("Explanation: Buy on day 2 (price=" + arr[1] + "), " + "and sell on day 3 (price is " + arr[2] + "); profit is " + 
				arr[2] + "-" +  arr[1] + "=" + a);
		
		System.out.println("Then buy on day 4 (price = " + arr[3] + "), and sell on day 5 (price is " + arr[3] + ")"); 
		
		System.out.println("Profit is " + arr[4] + "-" +  arr[3] + "=" + b) ;
		
		System.out.println("Then the total profit is: " + arr[arr.length-1] + "+" + arr[3]+ "= " +  c);
	}

}
