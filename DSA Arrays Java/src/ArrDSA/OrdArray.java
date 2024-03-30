//Author: John Photis
//Purpose: This Java program Implement the merge() and AddingTwo() methods to the OrdArray class

package ArrDSA;

import java.util.Scanner;

public class OrdArray {
	   private int[] a;                 // ref to array a
	   private int nElems;               // number of data items
	   
	//-----------------------------------------------------------
	   public OrdArray(int max) {          // constructor
	     a = new int[max];             // create array
	     nElems = 0;
	   }
	//-----------------------------------------------------------
	   
	   public int size() { 
	     return nElems; 
	   }
	   //-----------------------------------------------------------
	   
	   public int find(int searchKey) {
	     int lowerBound = 0;
	     int upperBound = nElems-1;
	     int curIn;
	     
	     while(true) {
	       curIn = (lowerBound + upperBound ) / 2;
	       if (a[curIn]==searchKey)
	         return curIn;              // found it
	       else if (lowerBound > upperBound)
	         return nElems;             // can't find it
	       else {                         // divide range
	         if (a[curIn] < searchKey)
	           lowerBound = curIn + 1; // it's in upper half
	         else
	           upperBound = curIn - 1; // it's in lower half
	       }  // end else divide range
	     }  // end while
	   }  // end find()
	   
	   //-----------------------------------------------------------
	   public void insert(int value) {   // put element into array
	      int j;
	      for (j=0; j<nElems; j++)        // find where it goes
	        if (a[j] > value)            // (linear search)
	        break;
	      for (int k=nElems; k>j; k--)    // move bigger ones up
	         a[k] = a[k-1];
	      a[j] = value;                  // insert it
	      nElems++;                      // increment size
	   }  // end insert()
	   
	   //-----------------------------------------------------------
	   public boolean delete(int value) {
	      int j = find(value);
	      if (j==nElems)                  // can't find it
	         return false;
	      else                           // found it
	         {
	         for(int k=j; k<nElems; k++) // move bigger ones down
	            a[k] = a[k+1];
	         nElems--;                   // decrement size
	         return true;
	         }
	      }  // end delete()
	   
	   //-----------------------------------------------------------
	   public void display() {             // displays array contents
	      for (int j=0; j<nElems; j++)       // for each element,
	        System.out.print(a[j] + " ");  // display it
	      System.out.println("");
	   }
	   
	   @Override
	   public String toString() {
		   StringBuilder sb = new StringBuilder();
		   for (int i=0; i<nElems; i++){
			   sb.append(a[i]+" ");
		   }
		   return sb.toString();
	   }
	   //-----------------------------------------------------------
	   
		public int[] merge(OrdArray arr) {
			// YOUR CODES
			 int[] result = new int[nElems + arr.nElems];
		        int i = 0, j = 0, index = 0;
		        while (i < nElems || j < arr.nElems) {
		            if (i < nElems && (j >= arr.nElems || a[i] <= arr.a[j])) {
		                result[index++] = (int) a[i++];
		            } else {
		                result[index++] = (int) arr.a[j++];
		            }
		        }
		        return result;
		    }

		public int[] addTwo(int target) {
			// YOUR CODES
			 int[] result = {-1, -1};
		        for (int i = 0; i < a.length; i++) {
		            for (int j = i + 1; j < a.length; j++) {
		                if (a[i] + a[j] == target) {
		                    result[0] = i;
		                    result[1] = j;
		                }
		            }
		        }
		        return result;
		    }
		     // For compilation, you need to change it.
	   
	   public static void main(String[] args){
	     // YOUR CODES to test the merge() method.
		   OrdArray arr1 = new OrdArray(100);
	        arr1.insert(1);
	        arr1.insert(3);
	        arr1.insert(5);
	        arr1.insert(5);
	        arr1.insert(7);
	        arr1.insert(9);
	        arr1.insert(11);
	        OrdArray arr2 = new OrdArray(100);
	        arr2.insert(2);
	        arr2.insert(4);
	        arr2.insert(6);
	        arr2.insert(8);
	        arr2.insert(10);
	        arr2.insert(10);
	        System.out.println("The first ordered array is:");
	        arr1.display();
	        System.out.println("The second ordered array is:");
	        arr2.display();
	        System.out.println("The merged ordered array is:");
	        int[] result = arr1.merge(arr2);
	        for (int i = 0; i < result.length; i++) {
	            System.out.print(result[i] + " ");
	        }
	        System.out.println();
	    } 
}
		 // The following are the codes to test the addTwo() method
//		 OrdArray arr  = new OrdArray(50);
//		 arr.insert(12);
//		 arr.insert(10);
//		 arr.insert(24);
//		 arr.insert(0);
//		 arr.insert(6);
//		 arr.insert(5);
//		 arr.insert(7);
//		 arr.insert(2);
//		 arr.display();
//		 
//		 Scanner console = new Scanner(System.in);
//		 System.out.print("Please enter a target number: ");
//		 int target = console.nextInt();
//		 int[] result = arr.addTwo(target);
//		 System.out.println("The two elements that can add up to " + target + " are at indexes: " + result[0] + " " + result[1]);
//		 console.close();
//	   }
//	   
//	}  // end class OrdArray