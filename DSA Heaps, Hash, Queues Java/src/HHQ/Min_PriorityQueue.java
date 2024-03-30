//Author: John Photis
//Purpose: This Java program implements	Minimum	Priority Queue using Min_Heap.	

package HHQ;

public class Min_PriorityQueue {
	// array in sorted order, from max at 0 to min at size-1
	private int maxSize;
	private MinHeap theHeap;
	private int nItems;
	// -------------------------------------------------------------

	public Min_PriorityQueue(int size) {// constructor
		// YOUR CODES
		theHeap = new MinHeap(size);
		maxSize = size;
		nItems = 0;
	}

	// -------------------------------------------------------------
	public void insert(int item) {// insert item
		// YOUR CODES
		if (theHeap.insert(item)) {
			nItems++;
		}
	} // end insert()

	public int remove() { // remove minimum item
		// YOUR CODES
		int least = theHeap.remove().getKey();
		nItems--;
		return least;
	}

	// -------------------------------------------------------------
	public int peek() {// peek at minimum item
	 // YOUR CODES
		int least = theHeap.remove().getKey();
		theHeap.insert(least);
		return least;
	}

	// -------------------------------------------------------------
	public boolean isEmpty() { // true if queue is empty
		// YOUR CODES
		 return theHeap.isEmpty(); // for compilation. you need to change it.
	}

	// -------------------------------------------------------------
	public boolean isFull() {// true if queue is full
	
		// YOUR CODES
		return(nItems == maxSize); // for compilation. You need to change it.
	}

	public static void main(String[] args) {
		Min_PriorityQueue thePQ = new Min_PriorityQueue(5);

		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);

		while (!thePQ.isEmpty()) {
			long item = thePQ.remove();
			System.out.print(item + " "); // 10, 20, 30, 40, 50
		}
		System.out.println("");
	} // end main()
}
