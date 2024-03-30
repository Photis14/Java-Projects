//Author: John Photis
//Purpose: This Java program implements a recursive	approach to	reverse	a given	linked list.


package DoublyLinkedList;

import java.util.Scanner;

public class ReverseLinkedList {
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

	static class LinkList {
		private Link first; // ref to first link on list

		// -------------------------------------------------------------
		public LinkList() // constructor
		{
			first = null; // no links on list yet
		}

		public void setFirst(Link l) {
			this.first = l;
		}

		public Link getFirst() {
			return this.first;
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
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Link current = first; // start at beginning of list
			while (current != null) // until end of list,
			{
				sb.append(current.iData + " "); // print data
				current = current.next; // move to next link
			}
			return sb.toString();
		}

		// -------------------------------------------------------------
		public static Link reverselinked(Link head) {
		       if(head == null) {
		           return head;
		       }
		       if(head.next == null) {
		           return head;
		       }

		       Link head1 = reverselinked(head.next);
		       head.next.next = head;
		       head.next = null;
		       return head1;
		   }
		
		public void reverse() {
			this.first=reverselinked(this.first);
		}
	} // end class LinkList

	////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		LinkList theList = new LinkList(); // make new list

		theList.insertFirst(1); // insert five items
		theList.insertFirst(2);
		theList.insertFirst(3);
		theList.insertFirst(4);
		theList.insertFirst(5);

		System.out.println(theList); // display list

		theList.reverse();

		System.out.println(theList);

	} // end main()
} // end class RemoveLinkedList