//Author: John Photis
//Purpose: This Java program follows the UML of the Crypto class.


package Classes;

import java.util.*;

public class Crypto {
	public int[] shuffleIndex;
	public Random rnd;
	
	public Crypto() {
		shuffleIndex = new int[10000];
		rnd = new Random();
	}

	public String encrypt(String string) {
		randomShuffle(string.length()); 

		char array[] = string.toCharArray();
		int j = 0;
		for (int i = string.length() - 1; i >= 1; i--) {
			int k = shuffleIndex[j];
			j++;
			char index = array[i];
			array[i] = array[k];
			array[k] = index;
		}

		return new String(array);
	}

	public String decrypt(String string) {
		char array[] = string.toCharArray();
		int j = string.length() - 2;

		for (int i = 1; i < string.length(); i++) {
			int k = shuffleIndex[j];
			j--;
			char temp = array[i];
			array[i] = array[k];
			array[k] = temp;
		}
		return new String(array);
	}

	public int limitedRand(int max) {
		return rnd.nextInt(max); 
	}

	public void randomShuffle(int n) {
		int k = 0;
		for (int i = n - 1; i >= 1; i--) {
			int j = limitedRand(i + 1);
			shuffleIndex[k] = j;
			k++;
		}
	}

	public void clear() {
		shuffleIndex = new int[10000];
	}


	
//-----------------------------------------------------------------------------------	

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Crypto first = new Crypto();
		for (int i = 0; i < 3; i++) {
			System.out.print("Please enter a string: ");
			String s = input.nextLine();
			String encrypted = first.encrypt(s);
			System.out.println("Encrypted: " + encrypted);
			System.out.println("Decrypted: " + first.decrypt(encrypted));
		}
	}
}
