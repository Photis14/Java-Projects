//Author: John Photis
//Purpose: This Java program groups	all	even Links together	followed by	all	the	odd Links.

package LinkedList;

import java.util.Scanner;

public class GroupLinkedList {
	static class Link {
		public String sData; // data item
		public Link next; // next link in list

		// -------------------------------------------------------------
		public Link(String s) // constructor
		{
			sData = s; // initialize data
			next = null;
		}
		
		// -------------------------------------------------------------

		public void displayLink() // display ourself
		{
			System.out.print("{" + sData + "} ");
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

		// -------------------------------------------------------------
		public boolean isEmpty() // true if list is empty
		{
			return (first == null);
		}

		// -------------------------------------------------------------
		// insert at start of list
		public void insertFirst(String s) { // make new link
			Link newLink = new Link(s);
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
				sb.append("{" + current.sData + "} ");
				current = current.next; // move to next link
			}
			return sb.toString();
		}

		// -------------------------------------------------------------
		public void group() {
			// YOUR CODES
			if (first == null) {
				System.out.println(first);
			
		
			if(first != null || first.next != null){
		        Link last = first; 
		        Link last1 = first.next;
		        Link e_first = last1;
		        while(last.next != null && last1.next != null){
		        	last.next = last1.next;
		        	last = last.next; 
		        	last1.next = last.next; 
		        	last1 = last1.next;
		        }
		        Link current = e_first;  
		        while(current.next != null)
		        	current = current.next;
		        current.next = first; 
		        first = e_first;  
		        last.next = null;  
			}
			}

	}// end class LinkList
		////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		LinkList theList = new LinkList(); // make new list

		theList.insertFirst("a"); // insert seven items
		theList.insertFirst("b");
		theList.insertFirst("a");
		theList.insertFirst("b");
		theList.insertFirst("a");
		theList.insertFirst("b");
		theList.insertFirst("a");
		theList.displayList(); // display list
		
		theList.group();
		System.out.println(theList.toString());

		//theList.displayList();
		//System.out.println(theList.toString());
	} // end main()
	}
}// end class GroupLinkedList
