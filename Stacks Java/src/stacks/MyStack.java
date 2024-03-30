//Author: John Photis
//Purpose: This Java program follows the UML of the MyStack class.

package stacks;

import java.util.*;

public class MyStack {

	public static void MyStack() {
	}

	public static void push(Stack stack) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an object: ");
		String object1 = input.next();

		System.out.println("Enter an object: ");
		String object2 = input.next();

		System.out.println("Enter an object: ");
		String object3 = input.next();

		System.out.println("Enter an object: ");
		int object4 = input.nextInt();

		System.out.println("Enter an object: ");
		int object5 = input.nextInt();

		stack.push(object1);
		stack.push(object2);
		stack.push(object3);
		stack.push(object4);
		stack.push(object5);
	}

	public static void pop(Stack stack) {
	}

	public static void peek(Stack stack) {
	}

	public static void getSize(Stack stack) {
	}

	public static void empty(Stack stack) {
	}

    public static String toString(Stack stack) {
        String srting = "";
        while (!stack.empty()) {
        	srting = srting + stack.pop().toString() + " ";
        }

        return srting;
}



	
//-----------------------------------------------------------------
	
	
	public static void main(String[] args) {
		Stack stack = new Stack<>();

		push(stack);

		 String s = toString(stack);
		 System.out.println("The objects in the Stack are: " + s);
	}
}
	
