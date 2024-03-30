package HHQ;

class Node {
	private int iData; // data item (key)

	public Node(int key) // constructor
	{
		iData = key;
	}

	public int getKey() {
		return iData;
	}

	public void setKey(int id) {
		iData = id;
	}

	public String toString() {
		return this.iData + " ";
	}
}

public class MinHeap {
	private Node[] heapArray;
	private int maxSize; // size of array
	private int currentSize; // number of nodes in array

	// -------------------------------------------------------------

	public MinHeap(int mx) // constructor
	{
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize]; // create array
	}

	// -------------------------------------------------------------
	public boolean isEmpty() {
		return currentSize == 0;
	}

	// -------------------------------------------------------------
	public boolean insert(int key) {// YOUR CODES
		if (currentSize == maxSize) // if array is full, key cannot be added
			return false;
		Node node = new Node(key); // make a new Node
		heapArray[currentSize] = node; // put it at the end
		trickleUp(currentSize++); // trickle it up

		return true; // For compilation. You need to change it.
	}

	// -------------------------------------------------------------
	public void trickleUp(int index) {
		int parent = (index - 1) / 2;
		Node bottom = heapArray[index];

		while (index > 0 && heapArray[parent].getKey() > bottom.getKey()) {

			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}

		heapArray[index] = bottom;
	}

	// -------------------------------------------------------------
	public Node remove() // delete item with max key. Return the reference to
							// the deleted node.
	{ // (assumes non-empty list)
		// YOUR CODES
		Node root = heapArray[0]; // save the root
		heapArray[0] = heapArray[--currentSize]; // root<-last
		trickleDown(0); // trickle down the root
		return root; // for compilation. you need to change it.

	}

	// -------------------------------------------------------------
	public void trickleDown(int index) {
		Node top = heapArray[index];
		int minChild;

		while (index < currentSize / 2) { // while the node has at lease one
											// child
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;

			if (rightChild <= currentSize && heapArray[rightChild].getKey() > heapArray[leftChild].getKey()) {
				minChild = leftChild;
			} else
				minChild = rightChild;

			if (top.getKey() <= heapArray[minChild].getKey())
				break;

			heapArray[index] = heapArray[minChild];
			index = minChild;
		}

		heapArray[index] = top;
	}

	// -------------------------------------------------------------
	public void displayHeap() {
		System.out.print("heapArray: "); // array format
		for (int m = 0; m < currentSize; m++)
			if (heapArray[m] != null)
				System.out.print(heapArray[m].getKey() + " ");
			else
				System.out.print("-- ");
		System.out.println();
		// heap format
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0; // current item
		String dots = "...............................";
		System.out.println(dots + dots); // dotted top line

		while (currentSize > 0) // for each heap item
		{
			if (column == 0) // first item in row?
				for (int k = 0; k < nBlanks; k++) // preceding blanks
					System.out.print(' ');
			// display item
			System.out.print(heapArray[j].getKey());

			if (++j == currentSize) // done?
				break;

			if (++column == itemsPerRow) // end of row?
			{
				nBlanks /= 2; // half the blanks
				itemsPerRow *= 2; // twice the items
				column = 0; // start over on
				System.out.println(); // new row
			} else // next item on row
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' '); // interim blanks
		} // end for
		System.out.println("\n" + dots + dots); // dotted bottom line
	} // end displayHeap()

	public static void main(String[] args) throws Exception {
		MinHeap theHeap = new MinHeap(31); // make a Heap; max size 31

		theHeap.insert(70); // insert 10 items
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);

		while (!theHeap.isEmpty()) {
			Node node = theHeap.remove();
			System.out.println(node.getKey());
		}

	} // end main()
}
