//Author: John Photis
//Purpose: This Java program implements	all the feature of a stack.


package Stack;

public class StackX {
	private int maxSize; // size of stack array
	private int[] stackArray;
	private int top; // top of stack
	// --------------------------------------------------------------

	public StackX(int s) // constructor
	{
		maxSize = s; // set array size
		stackArray = new int[maxSize]; // create array
		top = -1; // no items yet
	}
	// --------------------------------------------------------------

	public void push(int j) {// put item on top of stack
		// YOUR CODES
		if (top+1 >= stackArray.length) {
            int[] temp = new int[stackArray.length*2];
            for (int i = 0; i < stackArray.length; i++) {
                temp[i] = stackArray[i];
            }
            stackArray = temp;
        }
        stackArray[++top] = j;
    }
	
	// --------------------------------------------------------------

	public int pop() // take item from top of stack
	{
		// YOUR CODES
		return stackArray[top--];  // This is for compilation. You need to change it.
	}
	// --------------------------------------------------------------

	public int peek() // peek at top of stack
	{
		return stackArray[top];
	}
	// --------------------------------------------------------------

	public boolean isEmpty() // true if stack is empty
	{
		return (top == -1);
	}
	// --------------------------------------------------------------

	public boolean isFull() // true if stack is full
	{
		return (top == maxSize - 1);
	}
	// --------------------------------------------------------------

	public void display() {
		for (int i = top; i >= 0; i--) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}

	// ----------------------------------------------------------------
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = top; i >= 0; i--) {
			s.append(stackArray[i] + " ");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		StackX theStack = new StackX(5); // make new stack
		theStack.push(20); // push items onto stack
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);
		theStack.push(100);
		theStack.push(120);
		theStack.push(150);

		theStack.display();

		theStack.pop(); // pop out items
		theStack.pop(); // pop out items
		theStack.pop(); // pop out items
		theStack.pop(); // pop out items
		theStack.pop(); // pop out items
		theStack.pop(); // pop out items

		theStack.display();

	} // end main()
} // end class StackX