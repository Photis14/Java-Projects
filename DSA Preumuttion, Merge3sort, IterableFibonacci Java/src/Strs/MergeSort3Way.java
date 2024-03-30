//Author: John Photis
//Purpose: This Java program implements a MergeSort3Way	class so that arrays can be	sorted by using	Merge Sort 3-Way

package Strs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class DArray {
	private long[] theArray; // ref to array theArray
	private int nElems; // number of data items
	// -----------------------------------------------------------

	public DArray(int max) // constructor
	{
		theArray = new long[max]; // create array
		nElems = 0;
	}

	// -----------------------------------------------------------
	public void insert(long value) // put element into array
	{
		theArray[nElems] = value; // insert it
		nElems++; // increment size
	}

	// -----------------------------------------------------------
	@Override
	public String toString() // displays array contents
	{
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < nElems; j++) // for each element,
			sb.append(theArray[j] + " "); // display it
		return sb.toString();
	}

	// -----------------------------------------------------------
	public void mergeSort3Way() // called by main()
	{
		long[] workSpace = new long[nElems];
		recMergeSort3Way(workSpace, 0, nElems - 1);
	}

	// -----------------------------------------------------------
	private void recMergeSort3Way(long[] workSpace, int low, int high) {
		// YOUR CODES
		if (low < high) {
			int size = ((high - low) / 3);
			int mid1 = low + size;
			int mid2 = low + 2 * size;

			recMergeSort3Way(workSpace, low, mid1);
			recMergeSort3Way(workSpace, mid1 + 1, mid2);
			recMergeSort3Way(workSpace, mid2 + 1, high);
			merge(workSpace, low, mid1, mid2, high);
		}
	}
	// -----------------------------------------------------------

	private void merge(long[] workSpace, int low, int mid1, int mid2, int high) {
		// YOUR CODES
		int i = low, j = mid1 + 1, k = mid2 + 1;
		int n = low;

		while (i <= mid1 && j <= mid2 && k <= high) {
			if (theArray[i] <= theArray[j] && theArray[i] <= theArray[k]) {
				workSpace[n++] = theArray[i++];
			} else if (theArray[j] < theArray[i] && theArray[j] <= theArray[k]) {
				workSpace[n++] = theArray[j++];
			} else {
				workSpace[n++] = theArray[k++];
			}
		}

		while (i <= mid1 && j <= mid2) {
			if (theArray[i] <= theArray[j]) {
				workSpace[n++] = theArray[i++];
			} else {
				workSpace[n++] = theArray[j++];
			}
		}

		while (i <= mid1 && k <= high) {
			if (theArray[i] <= theArray[k]) {
				workSpace[n++] = theArray[i++];
			} else {
				workSpace[n++] = theArray[k++];
			}
		}

		while (j <= mid2 && k <= high) {
			if (theArray[j] <= theArray[k])
				workSpace[n++] = theArray[j++];
			else
				workSpace[n++] = theArray[k++];
		}

		while (i <= mid1) {
			workSpace[n++] = theArray[i++];
		}

		while (j <= mid2) {
			workSpace[n++] = theArray[j++];
		}

		while (k <= high) {
			workSpace[n++] = theArray[k++];
		}

		for (i = low; i <= high; i++) {
			theArray[i] = workSpace[i];
		}
	}


	// -----------------------------------------------------------

	public void writeToFile(String filename) {
		// YOUR CODES
		// Please add the try/catch statement for file processing
		try {
			PrintWriter writer = new PrintWriter(filename); // open the file in output mode
			for (int i = 0; i < nElems; i++) {
				writer.print(theArray[i] + "");
				if (i < nElems - 1)
					writer.print(" ");
			}

			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file: " + filename);
		}
	}
} // end class DArray

public class MergeSort3Way {
	public static void main(String[] args) {
		int maxSize = 1000001; // array size
		DArray arr; // reference to array
		arr = new DArray(maxSize); // create the array
		try {
			Scanner fileScan = new Scanner(new File("largeW.txt"));
			while (fileScan.hasNextLong()) {
				long value = fileScan.nextLong();
				arr.insert(value);
			}
			fileScan.close();

			arr.mergeSort3Way();
			arr.writeToFile("largeWResults.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		}
		// Read data from the file. Please add the try/catch statement for file
		// processing
		// Invoke MergeSort3Way
		// write sorted data to File.
	}
}