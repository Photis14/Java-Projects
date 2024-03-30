//Author: John Photis
//Purpose: This Java program follows the client program of Shopping.


package Geometry;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Scanner;

public class Shopping {

	public static ArrayList<String> getCommon(String filename) {
		ArrayList<String> Sally = new ArrayList<String>();
		ArrayList<String> Emma = new ArrayList<String>();
		ArrayList<String> commonItems = new ArrayList<String>();

		try {
			Scanner FilePath = new Scanner(new File("C:\\Users\\Yianni\\Desktop\\SallyAndEmma.txt"));
			String line;

			while (FilePath.hasNextLine() && (line = FilePath.nextLine()).charAt(0) != '#') {
				String itemName = line.split("\t")[0];
				Sally.add(itemName);
			}

			while (FilePath.hasNextLine()) {
				line = FilePath.nextLine();
				String itemName = line.split("\t")[0];
				Emma.add(itemName);
			}
			for (int i = 0; i < Emma.size(); i++) {
				if (Sally.contains(Emma.get(i)))
					commonItems.add(Emma.get(i));
			}

			FilePath.close();

		}

		catch (FileNotFoundException e) {
			System.out.println("Failed to open file!");

		}
		return commonItems;

	}

	public static String whichMore(String filename) {
		Double Sally = 0.0;
		Double Emma = 0.0;

		try {
			Scanner FileRead = new Scanner(new File("C:\\Users\\Yianni\\Desktop\\SallyAndEmma.txt"));
			String line;
			while (FileRead.hasNextLine() && (line = FileRead.nextLine()).charAt(0) != '#')
				Sally += Double.parseDouble(line.split("\t")[1]);
			while (FileRead.hasNextLine()) {
				line = FileRead.nextLine();
				Emma += Double.parseDouble(line.split("\t")[1]);
			}

			FileRead.close();

			if (Sally > Emma) {
				return "Sally";
			} else {
				return "Emma";

			}
		}

		catch (FileNotFoundException e) {

			return "";

		}

	}

	public static void main(String[] args) throws IOException {
		ArrayList<String> commonItems = getCommon("SallyandEmma.txt");
		String name = whichMore("SallyandEmma.txt");

		if (!name.equals("")) {
			FileWriter WriteFile = new FileWriter("Summary.txt");
			WriteFile.write("Common Items:\n");
			for (int i = 0; i < commonItems.size(); i++)
				WriteFile.write(commonItems.get(i) + " ");
			WriteFile.write("\n\n" + name + " spent more.\n");
			WriteFile.close();
		}

	}

}