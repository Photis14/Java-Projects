//Author: John Photis
//Purpose: This Java program implement a stream	of integers	and	a window size, calculate the 
//moving average of all integers in the sliding window.

package Queues;

import java.util.Scanner;
import java.util.ArrayList;


public class MovingAverage {
	private QueueX queue;
	private int size;
	private long sum = 0;
	int arr[];
	int i;
	boolean isFull;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {//
		this.queue = new QueueX();
		this.size = size;
		arr = new int[size];
		this.i = 0;
		sum = 0;
		isFull = false;

	}
	

	// checks sum, size and average of the queue
	public double next(int val) {
		sum += val;
        queue.enqueue(val);
  
        if (queue.size() > size)
        {
            sum -= queue.dequeue();
        }
		return val;
    }
	public double getMean()
    {
        return sum / size;
    }
		
//		if(i == size) {
//			i = 0;
//			isFull = true;
//			}
//			if(isFull) {
//			sum = sum + val - arr[i];
//			return sum/this.size;
//			}else {
//			sum += val;
//			}
//			arr[i++] = val;
//			return sum/i;
	
		// DO NOT CHANGE THE MAIN METHOD
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number to specify the window size: ");
		int window = input.nextInt();
		MovingAverage m = new MovingAverage(window);

		ArrayList<Double> arrList = new ArrayList<Double>();
		for (int i = 0; i < window + 5; i++) {
			System.out.print("Please enter a number to be added into the window: ");
			int num = input.nextInt();
			double avg = m.next(num);
			System.out.println("The average after adding the above number is: " + avg);
			arrList.add(avg);
		}
		input.close();
		System.out.println("Averages in the sequence are: " + arrList);
	}
}




