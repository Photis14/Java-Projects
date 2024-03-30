//Author: John Photis
//Purpose: This Java program follows the UML of the ProcessArray class.


package Classes;

import java.util.*;

public class ProcessArrayList {
	public static void removeAll(ArrayList<Integer> aList, Integer n) {

		while (aList.contains(n)) {
			aList.remove(n); 
		}
	}

	
//-----------------------------------------------------------------------------------------------------	
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(2);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(2);
		intList.add(6);
		intList.add(6);
		intList.add(2);
		intList.add(2);
		intList.add(0);

		System.out.print("The current ArrayList is: ");
		for (int i = 0; i < intList.size(); i++) {
			System.out.print(intList.get(i) + " ");
		
		}
		
		System.out.print("\nPlease enter the target number to remove: ");
		int target = input.nextInt();
		removeAll(intList, target);
		System.out.print("After removal, the ArrayList is: ");
		for (int i = 0; i < intList.size(); i++) {
			System.out.print(intList.get(i) + " ");
			
		}
	}
}
	
	
	

