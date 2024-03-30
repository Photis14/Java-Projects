//Author: John Photis
//Purpose: This Java program implements dequeue using doubly linked list. 

package LinkedList;

public class Deque {
	static class Link {
		public int dData; // data item
		public Link next; // next link in list
		public Link previous; // previous link in list

		public Link(int d) { // constructor
			dData = d;
			next = null;
			previous = null;
		}
		
		public void displayLink() { // display this link
			System.out.print(dData + " ");
		}
	} // end class Link

	private Link first; // ref to first item
	private Link last; // ref to last item
	
	// -------------------------------------------------------------
	// constructor
	public Deque() {
		first = null; // no items on list yet
		last = null;
	}
	
	/*
	 * insert at front of the deque
	 * equivalent to insertFirst on a doubly linked list
	 */
	public void addFront(int dd) {
		Link newLink = new Link(dd); // make new link

		if (isEmpty()) // if empty list,
			last = newLink; // newLink <-- last
		else
			first.previous = newLink; // newLink <-- old first
		
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	/* insert at end of the deque
	 * equivalent to insertLast on a doubly linked list
	 */
	public void addRear(int dd) { 
		// YOUR CODES
		Link newLink = new Link(dd);    // make new link

        if(isEmpty())   // if empty list
            first = newLink;     // newLink <-- first
        else    
            last.next = newLink;   // newLink <-- old last
        
        newLink.previous = last;   // newLink <-- old last
        last = newLink;    // last --> newLink
	}

	/*
	 * delete the first item
	 * equivalent to deleteFirst on a doubly linked list
	 */
	public int removeFront() { 
		// YOUR CODES
		 if(isEmpty())    // list is empty
	            return -1;
	        Link temp = first;
	        first = first.next;
	        first.previous = null;
	        int deleted_value = temp.dData;
	        return deleted_value; // For compilation. You need to change it.
	}

	/*
	 * delete the last item on the deque
	 * equivalent to deleteLast on a doubly linked list
	 */
	public int removeRear() {
		// YOUR CODES
		if(isEmpty())    // list is empty
            return -1;
        Link temp = last;
        last = last.previous;
        last.next = null;
        int deleted_value = temp.dData;
        return deleted_value; // For compilation. You need to change it.
	}

	/* display items on the deque
	 * 
	 */
	public void display() {
		// YOUR CODES
		// PLEASE DISPLAY YOUR DEQUE IN THE FOLLOWING FORMAT:
		// i.e.: [1, 3, 5]
		 if(isEmpty()) {
	            System.out.println("Deque is empty!");
	            return;
	        }
	        Link current = first;
	        while(current != null) {
	            current.displayLink();
	            current = current.next;
	        }
	        System.out.println();
	}

	// -------------------------------------------------------------
	public boolean isEmpty() { // true if no links
		// YOUR CODES
		if(first == null)
        return true;
    return false; // for compilation
	}
	//--------------------------------------------------------------
	
	public int size() {
		// YOUR CODES
		 int count = 0;
	        Link temp = first;
	        while(temp != null) {
	            count++;
	            temp = temp.next;
	        }
	        return count; // For compilation. You need to change it.
	}
	
	public static void main(String[] args) {
		// YOUR CODES FOR TESTING.
		 Deque d = new Deque();
		 	System.out.println("Operation         Return type         Deque content");
	        System.out.println("d.isEmpty()       " + d.isEmpty() );
	        d.addRear(4);
	        System.out.print("d.addRear(4)\t\t\t      "  );
	        d.display(); 
	        d.addRear(6);
	        System.out.print("d.addRear(6)\t\t\t      "  );
	        d.display();
	        d.addFront(0);
	        System.out.print("d.addFront(0)\t\t\t      "  );
	        d.display();
	        d.addFront(10);
	        System.out.print("d.addFront(0)\t\t\t      " );
	        d.display();
	        System.out.print("d.size()          " );
	        System.out.print(d.size()+ "\t\t      ");
	        d.display();
	        System.out.print("d.isEmpty()       " );
	        System.out.print(d.isEmpty()+ "\t\t      ");
	        d.display();
	        System.out.print("d.removeRear()    " );
	        System.out.print(d.removeRear()+ "\t\t      ");
	        d.display();
	        System.out.print("d.removeFront()   " );
	        System.out.print(d.removeFront()+ "\t\t      ");
	        d.display();
	        System.out.print("d.isEmpty()       " );
	        System.out.print(d.isEmpty()+ "\t\t      ");
	        d.display();
	     
	        
	}
}