//Author: John Photis
//Purpose: This Java program implements a 2d-Tree.

package BST;

import java.util.*;
import java.io.*;

public class TwoDTree {
	private Node root; // root of the KdTree

	static class Point2D {
		double x;
		double y;

		public Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	// 2d-tree (generalization of a BST in 2d) representation.
	static class Node {
		private Point2D p; // the point
		private Node left; // the left/bottom subtree
		private Node right; // the right/top subtree

		// Construct a node given the point
		Node(Point2D p) {
			this.p = p;
		}
	}

	public TwoDTree() {
		root = null;
	}

	public void insert(Point2D p) {
		root=insertHelper(root,p,0); 
	}

	public Node insertHelper(Node nodep, Point2D p, int coor) {
		if (nodep == null) {
			return new Node(p);
		}
		if (coor == 0) {
			if (p.x < nodep.p.x) {
				nodep.left = insertHelper(nodep.left, p, 1);
			} else {
				nodep.right = insertHelper(nodep.right, p, 1);
			}
		} else {
			if (p.y < nodep.p.y) {
				nodep.left = insertHelper(nodep.left, p, 0);
			} else {
				nodep.right = insertHelper(nodep.right, p, 0);
			}
		}

		return nodep;
	}
	
	public boolean search(Point2D p) {
		// YOUR CODES
		return searchHelper(root,p,0); // for compilation. you need to change it.
	}

	public boolean searchHelper(Node nodep, Point2D p, int cmp) {
		if (nodep == null)
			return false;
		if (nodep.p.x == p.x && nodep.p.y == p.y)
			return true;

		if (cmp == 0) {
			if (p.x < nodep.p.x)
				return searchHelper(nodep.left, p, 1); 
			else
				return searchHelper(nodep.right, p, 1);
		} else {
			if (p.y < nodep.p.y)
				return searchHelper(nodep.left, p, 0); 
			else
				return searchHelper(nodep.right, p, 0);
		}
	}

	public void display() {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (queue.size() != 0) {
			Node f = queue.peek();
			queue.remove();
			System.out.println("("+ f.p.x + ", " + f.p.y + ")");
			if (f.left != null) {

				queue.add(f.left);
			}
			if (f.right != null) {

				queue.add(f.right); // YOUR CODES
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// 1. YOUR CODES to Read file and build the tree by insertion
		// 2. Display the TwoDTree in Level-Order
		// 3. Search for some arbitrary points.
		TwoDTree tree = new TwoDTree();
		File file = new File("input10K.txt");
		BufferedReader buff = new BufferedReader(new FileReader(file));
		String string;
		while ((string = buff.readLine()) != null) {
			String[] s = string.split(" ");
			double x = Double.parseDouble(s[0]);
			double y = Double.parseDouble(s[1]);
			tree.insert(new Point2D(x, y));
		}

	}

}