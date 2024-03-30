//Author: John Photis
//Purpose: This Java program evaluates an infix	arithmetic expressions.	

package Queues;

import java.util.*;



public class Ramanujan {
	// A data type that encapsulates a pair of numbers (i, j) 
    // and the sum of their cubes, ie, i^3 + j^3.
	private static class Pair implements Comparable<Pair> {
		private int i; // first element of the pair
		private int j; // second element of the pair
		private int sumOfCubes; // i^3 + j^3
		
		
		// Construct a pair (i, j).
		Pair(int i, int j) {
			this.i = i;
			this.j = j;
			sumOfCubes = i * i * i + j * j * j;

		}

		// Compare this pair to the other by sumOfCubes.
		public int compareTo(Pair other) {
			if (this.sumOfCubes < other.sumOfCubes) {
				return -1;
			} else if (this.sumOfCubes > other.sumOfCubes) {
				return +1;
			} else {
				return 0;

			}

		}

	}

	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N, number, count;
		System.out.println("Please enter a number: ");
		number = input.nextInt();
		N = 1000;
		PriorityQueue<Pair> priQue = new PriorityQueue<Pair>();
		int k = 1;

		while (k <= N){
			priQue.add(new Pair(k, k));
			k++;

		}

		count = 1;
		Pair previous = new Pair(0, 0);
		while (!priQue.isEmpty())

		{

			Pair pvalue = priQue.poll();
			if (previous.sumOfCubes == pvalue.sumOfCubes && previous.sumOfCubes <= number) {
				count = count + 1;
				if (count == 2) {
					System.out.print(previous.sumOfCubes + " = " + previous.i + "^3 + " + previous.j + "^3");

				}

				System.out.print(" = " + pvalue.i + "^3 + " + pvalue.j + "^3");

			}

			else if (previous.sumOfCubes > number)

			{
				break;
			} else {
				if (count > 1) {
					System.out.println();
				}

				count = 1;
			}
			
			previous = pvalue;
			if (pvalue.j < N) {
				priQue.add(new Pair(pvalue.i, pvalue.j + 1));

			}
		}

		if (count > 1) {
			System.out.println();
		}
	}
}