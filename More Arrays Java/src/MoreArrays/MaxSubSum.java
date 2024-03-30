//Author: John Photis
//Due Date: October 18th, 2021
//Purpose: This Java program outputs the maximum subarray sum.
//Credits: I completed this program independently using class notes and the textbook. 


package MoreArrays;

import java.util.*;

public class MaxSubSum {

	    public static int[] getData(){
	    	Scanner input = new Scanner(System.in);
	        
	    	System.out.print("How many integers do you want to enter:? ");
	        int N = input.nextInt();
	        System.out.print("Please enter " + N + " integers: ");
	        int[] arr = new int [N];
	        for(int i=0;i<N;i++)
	        {
	            arr[i] = input.nextInt();
	        }
	        return arr;
	    }

	   public static int getMaxSubSum(int arr[]){
	        int max1 = Integer.MIN_VALUE;
	        int max2 = 0;
	 
	        for (int i = 0; i < arr.length; i++)
	        {
	        	max2 = max2 + arr[i];
	            if (max1 < max2)
	            	max1 = max2;
	            if (max2 < 0)
	            	max2 = 0;
	        }
	        return max1;
	    }
	   	 public static void main (String[] args){
		        int [] arr = getData();
		        System.out.println("The maximum subarray sum is " + getMaxSubSum(arr));

	}

}
