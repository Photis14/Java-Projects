//Author: John Photis
//Purpose: This Java program removed the n-th node from	the	end of the list.	

package LinkedList;

import java.util.Scanner;


public class RemoveLinkedList {
	static class Link {
		public int iData; // data item
		public Link next; // next link in list

		// -------------------------------------------------------------
		public Link(int id) // constructor
		{
			iData = id; // initialize data
			next = null;
		}

		// -------------------------------------------------------------

		public void displayLink() // display ourself
		{
			System.out.print("{" + iData + "} ");
		}
	} // end class Link
		////////////////////////////////////////////////////////////////

	private static class LinkList {
		private Link first; // ref to first link on list

		// -------------------------------------------------------------
		public LinkList() // constructor
		{
			first = null; // no links on list yet
		}

		public Link getFirst() {
			return first;
		}

		public void setFirst(Link l) {
			first = l;
		}

		// -------------------------------------------------------------
		public boolean isEmpty() // true if list is empty
		{
			return (first == null);
		}

		// -------------------------------------------------------------
		// insert at start of list
		public void insertFirst(int id) { // make new link
			Link newLink = new Link(id);
			newLink.next = first; // newLink --> old first
			first = newLink; // first --> newLink
		}

		// -------------------------------------------------------------
		public Link deleteFirst() // delete first item
		{ // (assumes list not empty)
			Link temp = first; // save reference to link
			first = first.next; // delete it: first-->old next
			return temp; // return deleted link
		}

		// -------------------------------------------------------------
		public void displayList() {
			System.out.print("List (first-->last): ");
			Link current = first; // start at beginning of list
			while (current != null) // until end of list,
			{
				current.displayLink(); // print data
				current = current.next; // move to next link
			}
			System.out.println("");
		}
		// -------------------------------------------------------------

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("List (first-->last): ");
			Link current = first; // start at beginning of list
			while (current != null) // until end of list,
			{
				sb.append("{" + current.iData + "} ");
				current = current.next; // move to next link
			}
			return sb.toString();
		}

		// ----------------------------------------
		public Link removeN(int n) {
			// YOUR CODES
			if (first == null)
				return null;
			// get length of list
			Link current = first;
			int len = 0;
			while (current != null) {
				len++;
				current = current.next;
			}

			// if remove first node
			int fromStart = len - n + 1;
			if (fromStart == 1)
				return first.next;

			// remove non-first node
			current = first;
			int i = 0;
			while (current != null) {
				i++;
				if (i == fromStart - 1) {
					current.next = current.next.next;
				}
				current = current.next;
			}

			return first;
		}
			
			
	} // end class LinkList
	////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		LinkList theList = new LinkList(); // make new list

		theList.insertFirst(1); // insert seven items
		theList.insertFirst(2);
		theList.insertFirst(3);
		theList.insertFirst(4);
		theList.insertFirst(5);
		theList.insertFirst(6);
		theList.insertFirst(7);

		theList.displayList(); // display list

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number N, so that the Nth node from the end will be deleted: ");
		int pos = input.nextInt();
		input.close();

		theList.removeN(pos);
		
		if(pos==7) {
			theList.deleteFirst();
		}
		theList.displayList();
	} // end main()
}// end class RemoveLinkedList