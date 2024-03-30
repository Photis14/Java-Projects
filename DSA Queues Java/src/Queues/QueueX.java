package Queues;

public class QueueX {
	private int MAX = 10000;
	private int maxSize;
	private int[] queArray;
	private int front;
	private int rear;
	private int nItems;

	// --------------------------------------------------------------
	public QueueX() // constructor
	{
		maxSize = MAX;
		queArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public QueueX(int size) {
		maxSize = size;
		queArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// --------------------------------------------------------------
	public void enqueue(int j) // put item at rear of queue
	{
		if (isFull())  // a fixed capacity Queue.
			throw new IllegalStateException("Queue is full"); 
		
		if (rear == maxSize - 1) // deal with wraparound
			rear = -1;
		queArray[++rear] = j; // increment rear and enqueue
		nItems++; // one more item
	}

	// --------------------------------------------------------------
	public int dequeue() // take item from front of queue
	{
		if (isEmpty())
			throw new IllegalStateException("Queue is empty");
		
		int temp = queArray[front++]; // get value and incr front
		if (front == maxSize) // deal with wraparound
			front = 0;
		nItems--; // one less item
		return temp;
	}

	// --------------------------------------------------------------
	public int peekFront() // peek at front of queue
	{
		return queArray[front];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxSize);
	}

	// --------------------------------------------------------------
	public int size() // number of items in queue
	{
		return nItems;
	}

	public void display() {	
		if (front<=rear) {
			for (int i = front; i <=rear; i++) {
				System.out.print(queArray[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = front; i < maxSize; i++) {
				System.out.print(queArray[i] + " ");
			}
			for (int i=0; i<=rear; i++){
				System.out.print(queArray[i] + " ");
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		String s = "";
		if (front<=rear) {
			for (int i = front; i <=rear; i++) {
				s+=queArray[i]+" ";
			}
		} else {
			for (int i = front; i < maxSize; i++) {
				s+=queArray[i]+" ";
			}
			for (int i=0; i<=rear; i++){
				s+=queArray[i]+" ";
			}
		}
		return s.trim();
	}
	
	// --------------------------------------------------------------
	public static void main(String[] args) {
		QueueX theQueue = new QueueX(5); // queue holds at most can hold 10000
										// items
		theQueue.enqueue(10); // enqueue 4 items
		theQueue.enqueue(20);
		theQueue.enqueue(30);
		theQueue.enqueue(40);

		theQueue.display();
		
		theQueue.dequeue(); // dequeue 3 items
		theQueue.dequeue(); // (10, 20, 30)
		theQueue.dequeue();

		theQueue.display();
		
		theQueue.enqueue(50); // enqueue 4 more items
		theQueue.enqueue(60); // (wraps around)
		theQueue.enqueue(70);
		theQueue.enqueue(80);
		
		// Display the current content of the Queue without dequeuing items.
		theQueue.display();
		//System.out.println(theQueue.toString());
		
		while (!theQueue.isEmpty()) // dequeue and display
		{ // all items
			int n = theQueue.dequeue(); // (40, 50, 60, 70, 80)
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");
	} // end main()

} // end class QueueX
