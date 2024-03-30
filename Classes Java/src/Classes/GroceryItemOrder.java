//Author: John Photis
//Purpose: This Java program follows the UML of the GroceryItem class.

package Classes;

public class GroceryItemOrder {
	String name;         
	int quantity;        
	double pricePerUnit; 

	public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
		this.quantity = quantity;
		this.name = name;
		this.pricePerUnit = pricePerUnit;
	}

	public double getCost() {
		return this.quantity * this.pricePerUnit;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
	