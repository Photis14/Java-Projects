//Author: John Photis
//Purpose: This Java program follows the client program of Counting and Searching in a file.

package Geometry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountAndSearch {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CountAndSearch countandsearch = new CountAndSearch();
		System.out.print("Please enter the filename: ");
		String filename = input.nextLine();
		
		try {
			int[] results = countandsearch.statistic(new Scanner(new File(filename))); // C:\\Users\\Yianni\\Desktop\\WutheringHeights.txt
			System.out.println("There are " + results[1] + " words.");
			System.out.println("There are " + results[0] + " characters.");
			System.out.println("There are " + results[2] + " lines.");
			System.out.println();
			System.out.print("Please enter a word: ");
			String word = input.next();
			System.out.println("\"" + word + "\" appears in the following lines: " + countandsearch.search(new Scanner(new File(filename)), word));
		} catch (FileNotFoundException e) {
			System.out.println("Failed to open file! " + filename);
		}
	}

	public int[] statistic(Scanner input) {
		int[] results = new int[3];
		String line;
		while (input.hasNextLine()) {
			line = input.nextLine();
			results[2]++;
			for (String word : line.split(" ")) {
				results[0] += word.length();
				results[1]++;
			}
		}

		return results;
	}

	public ArrayList<Integer> search(Scanner input, String word) {
		ArrayList<Integer> result = new ArrayList<>();
		boolean count = false;
		int numline = 1;
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.contains(word)) {
				result.add(numline);
				count = true;
			}

			numline++;
		}
		if (count == false)
			return null;
		return result;
	}
}
