//Author: John Photis
//Purpose: This Java program groups anagrams together from an array.

package HHQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Anagrams {
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] input) {
		Hashtable<String, ArrayList<String>> hashTable = new Hashtable<String, ArrayList<String>>();
		for (int i = 0; i < input.length; i++) {
			input[i] = input[i].toLowerCase();
			char[] c = input[i].toCharArray();
			Arrays.sort(c);
			String string = new String(c);

			if (!hashTable.containsKey(string)) {
				hashTable.put(string, new ArrayList<String>());
			}
			hashTable.get(string).add(input[i]);
		}
		ArrayList<ArrayList<String>> listReturned = new ArrayList<>();
		for (String string : hashTable.keySet()) {
			listReturned.add(hashTable.get(string));
		}

		return listReturned;
	} 

	public static void main(String[] args) {
		String[] input = { "eat", "tea", "tan", "ata", "nat", "bat" };
		ArrayList<ArrayList<String>> results = groupAnagrams(input);
		System.out.println(results);
	}
}