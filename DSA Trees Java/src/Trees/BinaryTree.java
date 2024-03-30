//Author: John Photis
//Purpose: This Java program implements	the	isSymmetric(), hasPath(), and getPaths() methods.

package Trees;

import java.util.*;

public class BinaryTree {
////////////////////////////////////////////////////////////////
	private Node root;

	static class Node {
		public int iData; // data item (key)
		public Node leftChild; // this node's left child
		public Node rightChild; // this node's right child

		public void displayNode() // display ourself
		{
			System.out.print(iData + " ");
		}

		public String toString() {
			return this.iData + "";
		}

		public boolean hasPath(int u, int v) {
			// TODO Auto-generated method stub
			return false;
		}
	} // end class Node

//-------------------------------------------------------------
	public BinaryTree() // constructor of the Binary Tree
	{
		root = null;
	} // no nodes in tree yet
//-------------------------------------------------------------

	public Node getRoot() {
		return this.root;
	}

	public void setRoot(Node p) {
		this.root = p;
	}

	public void insert(int id) {
		Node newNode = new Node(); // make new node
		newNode.iData = id; // insert data

		if (root == null) // no node in root
			root = newNode;
		else // root occupied
		{
			Random rnd = new Random();
			Node current = root;
			Node parent = root;
			int rand = 0;
			while (current != null) {
				parent = current;
				rand = rnd.nextInt(2);
				if (rand == 0)
					current = current.leftChild;
				else
					current = current.rightChild;
			}
			if (rand == 0)
				parent.leftChild = newNode;
			else
				parent.rightChild = newNode;
		}
	} // end insert()

//-------------------------------------------------------------

	/*
	 * Level-order traversal of the Tree
	 */
	public void displayTree() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node current = q.poll();
			current.displayNode();
			if (current.leftChild != null) {
				System.out.print("Left: " + current.leftChild.iData + "\t");
				q.add(current.leftChild);
			} else {
				System.out.print("Left:NULL" + "\t");
			}
			if (current.rightChild != null) {
				System.out.print("Right: " + current.rightChild.iData + "\n");
				q.add(current.rightChild);
			} else {
				System.out.println("Right:NULL");
			}
		}
		System.out.println();
	}

	public void displayTree2() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node current = q.poll();
			current.displayNode();
			if (current.leftChild != null) {
				q.add(current.leftChild);
			}
			if (current.rightChild != null) {
				q.add(current.rightChild);
			}
		}
	}

	/*
	 * @param another binary tree
	 * 
	 * @return return true or false indicating whether this binary tree is symmetric
	 * of itself.
	 */
	public boolean isSymmetric() {
		// YOUR CODES
		Queue<Node> q = new LinkedList<>();
		q.add(root.leftChild);
		q.add(root.rightChild);

		while (!q.isEmpty()) {
			Node tempLeft = q.remove();
			Node tempRight = q.remove();

			if (tempLeft == null && tempRight == null)
				continue;

			if ((tempLeft == null && tempRight != null) || (tempLeft != null && tempRight == null))
				return false;


			if (tempLeft.iData != tempRight.iData)
				return false;

			q.add(tempLeft.leftChild);
			q.add(tempRight.rightChild);
			q.add(tempLeft.rightChild);
			q.add(tempRight.leftChild);
		}
		return true;
	} // FOR COMPILATION, YOU NEED TO CHANGE IT

	public boolean hasPath(Node p, Node q) {
		// YOUR CODES
		if (p.leftChild == q || p.rightChild == q) {
			return true;
		} else {
			boolean a = false;
			if (p.leftChild != null)
				a = hasPath(p.leftChild, q);
			boolean b = false;
			if (p.rightChild != null)
				b = hasPath(p.rightChild, q);
			if (a || b)
				return true;
			else
				return false; // For compilation. You need to change it.
		}
	}


	public ArrayList<ArrayList<Integer>> getPaths() {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return null;
		else {
			ArrayList<Integer> path1 = new ArrayList<Integer>();
			getPaths(paths, path1, root);
			return paths; // FOR COMPILAION, YOU NEED TO CHANGE IT.
		}
	}

	public void getPaths(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path1, Node node) {
		if (node == null)
			return;
		if (node.leftChild == null && node.rightChild == null) {
			path1.add(node.iData);
			ArrayList<Integer> pathCopy = new ArrayList<>();
			pathCopy.addAll(path1);
			paths.add(pathCopy);
			path1.remove(path1.size() - 1);
		} else {
			path1.add(node.iData);
			if (node.leftChild != null) {
				getPaths(paths, path1, node.leftChild);
			}
			if (node.rightChild != null) {
				getPaths(paths, path1, node.rightChild);
			}
			path1.remove(path1.size() - 1);
		}
	}

	public static void main(String[] args) {
		// Sample Codes, Create a binary tree and display all the nodes in level-order
		BinaryTree theTree = new BinaryTree();
		theTree.insert(50);
		theTree.insert(25);
		theTree.insert(75);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(43);
		theTree.insert(30);
		theTree.insert(33);
		theTree.insert(87);
		theTree.insert(93);
		theTree.insert(97);

		theTree.displayTree();

		/*
		 * Problem 1: Call isSymmetric() to judge this binary tree is symmetric of
		 * itself around the center. YOUR CODES
		 */
		if (theTree.isSymmetric())
			System.out.println("The binary tree is Symmetric");
		else
			System.out.println("The binary tree is not Symmetric");
		/*
		 * Problem 2: First create two Nodes (suppose they both are on the tree), call
		 * the hasPath method to determine whether there is a path between them.
		 */
		Node g = new Node();
		int u = 3;
		int v = 7;
		System.out.print("Is there a path between node " + u + " and node "+ v + ": ");
		if (g.hasPath(u, v))
		System.out.print("true");
		else
		System.out.print("false");

		
		Node p = new Node();
		int t = 10;
		int y = 6;
		System.out.print("\nIs there a path between node " + t + " and node "+ y + ": ");
		if (p.hasPath(t, y))
		System.out.print("true");
		else
		System.out.print("false");
		/*
		 * Problem 3: Call the getPaths() method, and display all the root-to-leaf paths
		 * on the binary tree YOUR CODES
		 */
		theTree.getPaths();
	}
}