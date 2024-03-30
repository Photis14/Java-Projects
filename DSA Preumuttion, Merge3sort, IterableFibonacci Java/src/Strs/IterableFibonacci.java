//Author: John Photis
//Purpose: This Java program print all possible strings of length k that can be formed from the given set

package Strs;

import java.util.Iterator;


public class IterableFibonacci implements Iterable<Integer>{
	  
	class IteratorFibonacci implements Iterator<Integer>{
		   // YOUR CODES HERE
	       private int current; 
	       public IteratorFibonacci(){
	           current = 0;
	       }
	      
	       public boolean hasNext(){
	           return(current < n);
	       }
	      
	       public Integer next(){

	           Integer data = fibNumbers[current];
	           current++;
	           return data;
	       }
	      
	   }
	   // data field
	   private int n; 
	   private int fibNumbers[]; 
	   
	   // Constructor
	   public IterableFibonacci(int n){
	       this.n = n;
	       fibNumbers = new int[n];
	       if(n > 0)
	       {
	           if(n >= 1) {
	               fibNumbers[0] = 0;
	           }
	           if(n >= 2) {
	               fibNumbers[1] = 1;
	           }
	           for(int i=2;i<n;i++){
	               fibNumbers[i] = fibNumbers[i-1]+fibNumbers[i-2];
	           }
	       }
	   }
	// YOUR CODES HERE
	public Iterator<Integer> iterator() {
		return new IteratorFibonacci();
	}

	public static void main(String[] args) {
		int n = 7;
		System.out.println("For N = " + n);
		System.out.println("The first " + n + " numbers in the Fibonacci sequence would be: ");
		for (long i : new IterableFibonacci(n)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}




