//Author: John Photis
//Purpose: This Java program implements dequeue using doubly linked list. 


package DoublyLinkedList;

import java.util.*;
import java.io.*;

class Link {
	public int iData; // data item	
	public  Link next; // next link in list
	// -------------------------------------------------------------

	public Link(int id) // constructor
	{
		iData = id; // initialize data
		// next is null
	} // set to null)
	// -------------------------------------------------------------

	public void displayLink() // display ourself
	{
		System.out.print(iData + " ");
	}
} // end class Link
////////////////////////////////////////////////////////////////

class IterableLinkList implements Iterable<Link> {
	private Link first; // ref to first link on list

	// -------------------------------------------------------------
	public IterableLinkList() // constructor
	{
		first = null; // no links on list yet
	}
	
	public void setFirst(Link first) {
		this.first = first;
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

	public Link deleteFirst() // delete first item
	{ // (assumes list not empty)
		Link temp = first; // save reference to link
		first = first.next; // delete it: first-->old next
		return temp; // return deleted link
	}
	
	public Link find(int key) // find link with given key
	{ // (assumes non-empty list)
		Link current = first; // start at 'first'
		while (current.iData != key) // while no match,
		{
			if (current.next == null) // if end of list,
				return null; // didn't find it
			else // not end of list,
				current = current.next; // go to next link
		}
		return current; // found it
	}

	public Link delete(int key) // delete link with given key
	{ // (assumes non-empty list)
		if (first==null) return first;
		Link current = first; // search for link
		Link previous = first;
		while (current.iData != key) {
			if (current.next == null)
				return null; // didn't find it
			else {
				previous = current; // go to next link
				current = current.next;
			}
		} // found it
		if (current == first) // if first link,
			first = first.next; // change first
		else // otherwise,  to cover all the intermediate or the last node
			previous.next = current.next; // bypass it
		return current;
	}
	
	public void displayList() {
		Link current = first;
		while (current!=null) {
			current.displayLink();
			current = current.next;
		}
	}
	
//Author: John Photis
//Purpose: This Java program iterate over each link	on the list.

	public Iterator<Link> iterator() {
		return new LinkListIterator(first);    // for compilation. You need to change it.
	}
	
	public static void main(String[] args) throws Exception {
		IterableLinkList theList = new IterableLinkList(); // make new list

		theList.insertFirst(22); // insert four items
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertFirst(88);
		
		theList.displayList();
		
		Iterator<Link> it = theList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().iData);
		}
	} // end main()
}


class LinkListIterator implements Iterator<Link> {
	private Link current;
    public LinkListIterator(Link first){
        current = first;
    }
  
    public boolean hasNext()
    {
        return current != null;
    }
    public Link next(){
        Link temp = current;
        current = current.next;
        return temp;
    }
}
