//Author: John Photis
//Purpose: This Java program follows the UML of the GroceryList class.

package Classes;

import java.util.*;

public class GroceryList {
	GroceryItemOrder[] groceries; // A list of groceries
	int groceries_index; // Used to keep track of how many groceries there are.

	// Constructor
	public GroceryList() {
		groceries = new GroceryItemOrder[10];
		groceries_index = 0;
	}

	// Add a GroceryItemOrder to the List
	public void add(GroceryItemOrder item) {
		this.groceries[groceries_index] = item;
		groceries_index++;
	}

	// Gets total cost of all groceries in the cart
	public double getTotalCost() {
		   double totalCost = 0;
	        for (int i=0; i<groceries_index; i++) {
	            totalCost += groceries[i].getCost();
	        }
	        return totalCost;
	    }
	

//-----------------------------------------------------------------------------------------------------	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GroceryList list = new GroceryList();
		
		
		//First item
		System.out.println("Please enter the name of the item ordered: ");
		String order1item = input.nextLine();

		
		System.out.println("How many pounds ordered: ");
		int order1quan = input.nextInt();
		
		System.out.println("Please enter the price per pound: ");
		double order1price = input.nextDouble();
		
		GroceryItemOrder groceryorder1 = new GroceryItemOrder(order1item, order1quan, order1price);
		groceryorder1.setQuantity(order1quan);
		groceryorder1.getCost();
		list.add( groceryorder1 );
	
		//Second Item
		System.out.println("Please enter the name of the item ordered: ");
		input.nextLine();
		String order2item = input.nextLine();

		
		System.out.println("How many pounds ordered: ");
		int order2quan = input.nextInt();
		
		System.out.println("Please enter the price per pound: ");
		double order2price = input.nextDouble();
		
		GroceryItemOrder groceryorder2 = new GroceryItemOrder(order2item, order2quan, order2price);
		groceryorder2.setQuantity(order2quan);
		groceryorder2.getCost();
		list.add(groceryorder2);
		
		//Result
		System.out.println("The total cost of this purchase would be: ");
		System.out.println(order1item +": "+ String.format("%.2f", order1price*order1quan) );
		System.out.println(order2item +": "+ String.format("%.2f", order2price*order2quan));
		System.out.println("Total: "+  list.getTotalCost());

	}
}