//Author: John Photis
//Purpose: This Java program outputs the most frequent element of an array. 


package MoreArrays;

import java.util.*;

public class MostFrequent {

	  public static int getMostFrequent(int[] arr) {
	       if (arr.length == 0) {
	           return -1;
	       } else {
	           int element = 1; 
	           int mostfrequentelement = arr[0];
	           int index = 0;
	           for (int i = 0; i < arr.length - 1; i++) {
	        	   index = arr[i];
	               int count = 0;
	               for (int j = i + 1; j < arr.length; j++) {
	                   if (index == arr[j]) {
	                	   count += 1;
	                   }
	               }
	               if (count > element) {
	            	   mostfrequentelement = index;
	                   element = count;
	               }
	           }
	           return mostfrequentelement;
	       }
	   }

	   public static void main(String[] args) {
	       Scanner input = new Scanner(System.in);
	       
	       int n = input.nextInt();
	       int arr[] = new int[n];
	       
	       for (int i = 0; i < n; i++) {
	           arr[i] = input.nextInt();
	       }
	       System.out.println("The element appears most frequently is: " + getMostFrequent(arr));
		

	}

}
