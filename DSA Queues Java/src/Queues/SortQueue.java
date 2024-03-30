//Author: John Photis
//Purpose: This Java program implements the selection sort algorithm on a Queue of long-type items

package Queues;

import java.util.*;


public class SortQueue {
	public static QueueX selectionSortQ(QueueX myQ) {
        //YOUR CODES
		 for(int i = 1; i <= myQ.size(); i++) {  
	            int minin = findMinIndex(myQ,myQ.size() - i); 
	            insertMinToRear(myQ, minin); 
	        }
		return myQ; 
	    } 
	    
	    public static int findMinIndex(QueueX myQ, int sortIndex) { 
	        int minin = -1; 
	        long minval = Integer.MAX_VALUE; 
	        int size = myQ.size();
	        for (int i = 0; i < size; i++) 
	        { 
	            int temp = myQ.dequeue(); 
	            if (temp <= minval && i <= sortIndex) { 
	            	minin = i; 
	                minval = temp; 
	            } 
	            myQ.enqueue(temp);  
	        } 
	        return minin; 
	    }
	    public static void insertMinToRear(QueueX myQ ,int min_index) { 
	        int minval = 0;  
	        int size = myQ.size(); 
	        for (int i = 0; i < size; i++) { 
	            int temp = myQ.dequeue(); 
	            if (i != min_index) {
	            	myQ.enqueue(temp); 
	            } else
	                minval = temp; 
	        } 
	        myQ.enqueue(minval); 
	    }  
    
	
    public static void main(String args[]) {
        QueueX myQ= new QueueX(6);
        myQ.enqueue(4);
        myQ.enqueue(1);
        myQ.enqueue(5);
        myQ.enqueue(2);
        myQ.enqueue(1);
        myQ.enqueue(3);
        
        myQ.display();
        QueueX sortedQ = selectionSortQ(myQ);
        sortedQ.display();
    }
}