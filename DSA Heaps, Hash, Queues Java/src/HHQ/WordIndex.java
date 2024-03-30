//Author: John Photis
//Purpose: This Java program creates a hash	table from a text file.

package HHQ;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class WordIndex {

	/*
	 * Read the file to create the hash table for word index.
	 */
	public static HashMap<String, ArrayList<Integer>> getWordIndex(Scanner o) throws Exception {
		// YOUR CODES
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		int lineid = 1;
		while (o.hasNextLine()) {
			String line = o.nextLine();
			String[] words = line.split(" ");
			for (String word : words) {
				word = word.toLowerCase();
				if (!map.containsKey(word)) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(lineid);
					map.put(word, list);
				} else {
					ArrayList<Integer> list = map.get(word);
					if (!list.contains(lineid)) {
						list.add(lineid);
					}
					map.put(word, list);
				}
			}
			lineid++;
		}
		return map;
	}// For compilation. You need to change it.
	/*
	 * Write the generated hash table to a file index.txt
	 */
	public static void writeToFile(HashMap<String, ArrayList<Integer>> map) throws Exception {
		// YOUR CODES
		PrintWriter output = new PrintWriter(new File("index.txt"));
		Set<String> words = map.keySet();
		for (String word : words) {
			ArrayList<Integer> lines = map.get(word);
			output.print(word + ": ");
			for (Integer lineid : lines) {
				output.print(lineid + " ");
			}
			output.println();
		}
		output.close();
	}

	public static void main(String[] args) throws Exception {
		// YOUR CODES to read and write files.
		String filename = "Kennedy.bxt";
		Scanner input = new Scanner(new File(filename));
		WordIndex wi = new WordIndex();
		HashMap<String, ArrayList<Integer>> results = WordIndex.getWordIndex(input);
		wi.writeToFile(results);

	}
}

