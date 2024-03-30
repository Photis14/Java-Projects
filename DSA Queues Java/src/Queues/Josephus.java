//Author: John Photis
//Purpose: This Java program takes N and M from	keyboard and prints	out	the	order in which people are eliminated.	

package Queues;

import java.util.*;

public class Josephus {
	  public ArrayList<Integer> getJosephus(int N, int M){
	    // YOUR CODES
		  ArrayList<Integer> arr = new ArrayList<>();
	        Deque<Integer> deque  = new LinkedList<Integer>(); 
	        for(int i=0; i<N; i++) {
	            deque.addLast(i);
	        }
	        while(!deque.isEmpty()){
	            for(int i=1;i<M;i++){
	              deque.addLast(deque.pollFirst());  
	            }
	            arr.add(deque.pollFirst());
	        }
	        return arr;
	    } 
	  
	  
	  public static void main(String[] args) {
	    Josephus josephus = new Josephus();
	    Scanner input = new Scanner(System.in);
	    System.out.print("Please enter a number for N indicating the total number of people: ");
	    int N = input.nextInt();
	    System.out.print("Please enter a number for M indicating the Mth person to be eliminated: ");
	    int M = input.nextInt();
	    input.close();
	    
	    System.out.println("People will be deliminated in the following order: ");
	    System.out.println(josephus.getJosephus(N, M));
	  }
	}
