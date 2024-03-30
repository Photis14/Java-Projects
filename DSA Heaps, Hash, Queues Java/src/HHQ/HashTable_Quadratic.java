//Author: John Photis
//Purpose: This Java program implements a HashTable	of strings with	Quadratic Probing.

package HHQ;

import java.io.*;
import java.util.*;

public class HashTable_Quadratic {
	private String[] hashArray; // array holds hash table
	private int arraySize;

	// -------------------------------------------------------------
	public HashTable_Quadratic(int size) // constructor
	{
		arraySize = size;
		hashArray = new String[arraySize];
	}

	// -------------------------------------------------------------
	public void displayTable() {
		System.out.print("Table: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.print(hashArray[j] + " ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		String result = "";
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				result += hashArray[j] + " ";
			else
				result += "**";
		}
		return result;
	}

	// -------------------------------------------------------------
	public int hashFunc(String key) {
		// YOUR CODES
		int hash = 0;
		int keyLength = key.length();
		for (int i = 0; i < keyLength; i++) {
			char character = key.charAt(i);
			int asciiValue = (int) character;
			hash += asciiValue * Math.pow(26, keyLength - 1 - i); // For compilation. You need to change it.
		}
		int hashIndex = hash % arraySize;
		return hashIndex;
	}

	// -------------------------------------------------------------
	public void insert(String item) { // insert a DataItem
		// (assumes table not full)
		// YOUR CODES
		int hashIndex = hashFunc(item);
		int i = 1;
		int prevHashIndex = hashIndex;

		while (hashArray[hashIndex] != null) {
			hashIndex = (prevHashIndex + (int) (Math.pow(i, 2))) % arraySize;
			i++;
		}

		hashArray[hashIndex] = item;
		System.out.println("added item " + item + " to " + hashIndex);
	} // end insert()
		// -------------------------------------------------------------

	/* delete a key if exists and return that key.
	 * Otherwise return null
	 */
	public String delete(String key) {
		// YOUR CODES
		int hashIndex = hashFunc(key);
		if (hashArray[hashIndex] == key) {
			String value = hashArray[hashIndex];
			hashArray[hashIndex] = null;
			return value;
		} else {
			int i = 1;
			int prevHashIndex = hashIndex;
			while (hashArray[hashIndex] != key) {
				hashIndex = (int) (prevHashIndex + Math.pow(i, 2)) % arraySize;
				i++;
			}
			String value = hashArray[hashIndex];
			hashArray[hashIndex] = null;
			return value;
		} // For compilation. You need to change it.

	} // end delete()
		// -------------------------------------------------------------

	/* Return the key if exists. Otherwise return null
	 */
	public String find(String key) // find item with key
	{ // YOUR CODES
		int hashIndex = hashFunc(key);
		if(hashArray[hashIndex] == key){
		return hashArray[hashIndex];
		}else{
		int i = 1;
		int prevHashIndex = hashIndex;
		while(hashArray[hashIndex]!=key){
		hashIndex = (int) (prevHashIndex + Math.pow(i,2)) % arraySize;
		i++;
		}
		return hashArray[hashIndex];
		} // For compilation. You need to change it.
	}

	// -------------------------------------------------------------
	// end class HashTable

	public static void main(String[] args) throws IOException {
		int aKey, size, n, keysPerCell;

		// get the size of the HashTable
		Scanner console = new Scanner(System.in);
		System.out.print("Enter size of hash table: ");
		size = console.nextInt();

		// make the table
		HashTable_Quadratic table = new HashTable_Quadratic(size);
		table.insert("apple");
		table.insert("book");
		table.insert("car");
		table.insert("dog");
		table.insert("egg");
		table.insert("fish");
		table.insert("giraff");
		table.insert("horse");
		table.insert("ice");
		table.insert("jungle");

		// display the table
		table.displayTable();
	}
}
