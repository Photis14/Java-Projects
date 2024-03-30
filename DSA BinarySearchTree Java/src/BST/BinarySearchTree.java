//Author: John Photis
//Purpose: This Java program implements Binary Search Tree.

package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Iterator;

class Node {
	public int data; // data item (key)
	public Node left; // this node's left child
	public Node right;// this node's right child


	public Node(int data) {
		this.data = data;
	}

	public void displayNode() // display ourself
	{
		System.out.print(data + " ");
	}
	
	public String toString() {
		return this.data + " ";
	}
} // end class Node

public class BinarySearchTree implements Iterable<Node>{
	private Node root;
//-------------------------------------------------------------
	public BinarySearchTree()         // constructor of the Binary Tree
	{ this.root = null; }            // no nodes in tree yet
	
	public Node getRoot() {
		return this.root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void insert(int id) {
		Node newNode = new Node(id);    // make new node
		if(root==null)                // no node in root
			root = newNode;
		else {
			Node current = root;
			Node parent = root;
			while (current!=null){
				parent = current;
				if (id<current.data){
					current = current.left;
				} else {
					current = current.right;
				}
			}
			if (id<parent.data) parent.left = newNode;
			else parent.right = newNode;
		} 
	}  // end insert()
	
	/*
	 * @param none
	 * @return true or false indicating whether the tree is a binary search tree
	 */
	public boolean isBST(){
		// YOUR CODES
		return isBSTHelper(root);  // for compilation. You need to change it.
	}
	
	public boolean isBSTHelper(Node root) {
	    if(root == null) {
	        return true;
	    }
	    if(root.left == null && root.right == null) {
	        return true;
	    }
	    
	    boolean status = true;
	    if(root.left != null) {
	        status &= (root.data > root.left.data);
	        status &= isBSTHelper(root.left);
	    }
	    if(root.right != null) {
	        status &= (root.data < root.right.data);
	        status &= isBSTHelper(root.right);
	    }
	    
	    return status;
	}
	/*
	 * @param two nodes
	 * @return the data of the node which is the lowest common ancestor of node p and q;
	 * @return -1 if either p or q does not exist in the tree
	 */
	private List<Integer> firstpath = new ArrayList<>();
	private List<Integer> secondpath = new ArrayList<>();

	public int getLCA(Node p, Node q) {
		return getLCAHelper(root, p, q); // for compilation.
	}

	private int getLCAHelper(Node root, Node p, Node q) {
		if (!path(root, p, firstpath) || !path(root, q, secondpath)) {
			return -1;
		}

		int i;
		for (i = 0; i < firstpath.size() && i < secondpath.size(); i++) {
			if (!firstpath.get(i).equals(secondpath.get(i)))
				break;
		}

		return firstpath.get(i - 1);
	}

	private boolean path(Node root, Node p, List<Integer> path) {
		if (root == null) {
			return false;
		}

		path.add(root.data);

//		if (root.data == p) {
//		return true;
//		}

		if (root.left != null && path(root.left, p, path)) {
			return true;
		}

		if (root.right != null && path(root.right, p, path)) {
			return true;
		}

		path.remove(path.size() - 1);

		return false;
	}
	
	/*@return: an instance of Iterator Interface on Node.
	 */
	public Iterator<Node> iterator() {
		return null;  // for compilation
	}

	public static void main(String[] args) {
		Node root1 = new Node(2);
		Node left1 = new Node(1);
		Node right1 = new Node(3);
		root1.left = left1;
		root1.right = right1;
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.root = root1;
		System.out.println("Is the first tree a valid BST?: " + tree1.isBST());

		Node root2 = new Node(5);
		Node left2_1 = new Node(1);
		Node right2_1 = new Node(4);
		Node left2_2 = new Node(3);
		Node right2_2 = new Node(6);
		root2.left = left2_1;
		root2.right = right2_1;
		right2_1.left = left2_2;
		right2_2.right = right2_2;
		BinarySearchTree tree2 = new BinarySearchTree();
		tree2.root = root2;
		System.out.println("Is the second tree a valid BST?: " + tree2.isBST());

		BinarySearchTree tree3 = new BinarySearchTree();
		int[] nodes = { 6, 8, 2, 4, 0, 9, 7, 5, 3 };
		for (int n : nodes) {
			tree3.insert(n);
		}

		// YOUR CODES to get the LCA for the following two nodes' set:
		System.out.println("The LCA of node 2 and 8 is: " + tree3.getLCA(new Node(2), new Node(8)));
		// node 2 and node 8
		System.out.println("The LCA of node 0 and 3 is: " + tree3.getLCA(new Node(0), new Node(3)));
		// node 0 and node 3
		System.out.println("The LCA of node 2 and 10 is: " + tree3.getLCA(new Node(2), new Node(10)));
		// node 2 and node 10
		System.out.println("The LCA of node 1 and 3 is: " + tree3.getLCA(new Node(1), new Node(3)));
		// node 1 and node 3

		// Codes to test BSTIterator
		Iterator<Node> iter = tree3.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
	}
}

class BSTIterator implements Iterator<Node> {
	// YOUR CODES
	List<Node> treeNodes = new ArrayList<Node>();
	void insertNodes(Node root) {
		while (root != null) {
			treeNodes.add(root);
			root = root.left;
		}
	}
    
    public boolean hasNext() {
		return !treeNodes.isEmpty();
    }
    
    public Node next() {
		int last = treeNodes.size() - 1;
		Node currNode = treeNodes.get(last);
		treeNodes.remove(last);
		insertNodes(currNode.right);
		return currNode;
    }
}