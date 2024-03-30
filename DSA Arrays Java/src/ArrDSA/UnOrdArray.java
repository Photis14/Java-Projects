//Author: John Photis
//Due Date: Jan	30th, 2022
//Purpose: This Java program implements	the	removeMax() method,	so that	the	item in	the	array with the largest value can be returned.
//Credits: I completed this program independently using class notes and the textbook.


package ArrDSA;

class UnOrdArray {
	private int[] a; // ref to array a
	private int nElems; // number of data items

	// -----------------------------------------------------------
	public UnOrdArray(int max) { // constructor
		a = new int[max]; // create the array
		nElems = 0; // no items yet
	}
	// -----------------------------------------------------------

	public boolean find(int searchKey) { // find specified value
		int j;
		for (j = 0; j < nElems; j++) // for each element,
			if (a[j] == searchKey) // found item?
				break; // exit loop before end
		if (j == nElems) // gone to end?
			return false; // yes, can't find it
		else
			return true; // no, found it
	} // end find()
		// -----------------------------------------------------------

	public void insert(int value) { // put element into array
		a[nElems] = value; // insert it
		nElems++; // increment size
	}
	// -----------------------------------------------------------

	public boolean delete(int value) {
		int j;
		for (j = 0; j < nElems; j++) // look for it
			if (value == a[j])
				break;
		if (j == nElems) // can't find it
			return false;
		else { // found it
			for (int k = j; k < nElems; k++) // move higher ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
		// -----------------------------------------------------------

	public void display() { // displays array contents
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < nElems; i++) {
			result += a[i] + " ";
		}
		return result;
	}
	// -----------------------------------------------------------

	public int removeMax() {
		// YOUR CODES
		if (nElems == 0) {
            return -1;
        } else {
            int maxIndex = 0;
            for (int i = 0; i < nElems; i++) {
                if (a[i] > a[maxIndex]) {
                    maxIndex = i;
                }
            }
            long result = a[maxIndex];
            for (int i = 0; i < nElems; i++) {
                if (a[i] == result) {
                    for (int j = i; j < nElems - 1; j++) {
                        a[j] = a[j + 1];
                    }
                    nElems--;
                    i--;
                }
            }
            return (int) result;
        }
    }
		

	public static void main(String[] args) {
		int maxSize = 100; // array size
		UnOrdArray arr; // reference to array
		arr = new UnOrdArray(maxSize); // create the array

		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(99);
		arr.insert(66);
		arr.insert(33);

		System.out.println("The original array is:");
		arr.display();

		System.out.println("The maximum value is " + arr.removeMax());
		System.out.println("The array after removing the maximum value is:");
		arr.removeMax();
		arr.display();

		System.out.println("The maximum value is " + arr.removeMax());
		System.out.println("The array after removing the maximum value is:");
		arr.display();

		System.out.println("The maximum value is " + arr.removeMax());
		System.out.println("The array after removing the maximum value is:");
		arr.display();

	} // end main()
} // end class UnOrdArray