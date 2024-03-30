//Author: John Photis
//Purpose: This Java program implements getEncodes() and uncompress() methods.

package Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrefixTree {
	
	private Node root;
	private Scanner userInput;
	private Queue<Character> queue;

	public static class Node {
		private	char	character;
		private	Node	left;
		private	Node	right;
		
		public void displayNode()      // display ourself
		{
			System.out.print(character + " ");
		}
	}
	
	public static class Encode {
		private char character;
		private String encodes;
		
		public Encode(char character, String encodes) {
			// For example:  new Encode('a', "0");
			this.character = character;
			this.encodes = encodes;
		}
		
		public char getCharacter(){
			return this.character;	
		}
		
		public String getEncode() {
			return this.encodes;
		}
		
		public String toString() {
			return this.character + "\t" + this.encodes.length() + "\t" + this.encodes;
		}
	}
	
	//Displays the tree
	public void displayTree() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()){
			Node current = q.poll();
			current.displayNode();
			if (current.left!=null) {
				System.out.print(current.character + " " + "Left: " + current.left.character + "\t");
				q.add(current.left);
			}
			else {
				System.out.print(current.character + " " + "Left:NULL" + "\t");
			}
			if (current.right!=null) {
				System.out.print(current.character + " " + "Right: " + current.right.character + "\n");
				q.add(current.right);
			}
			else {
				System.out.println(current.character + " " + "Right:NULL");
			}
		}
		System.out.println();
	}
	
	// Constructor. First read the file and then build the Prefix Tree
	public PrefixTree() throws FileNotFoundException { 
		// test case of values 
		this.userInput = new Scanner(System.in);
		this.queue = new LinkedList<Character>();
		File file = new File("abra.pre");
		Scanner input = new Scanner(file);
		String line = input.nextLine().trim();
		
		char[] characters = line.toCharArray();
		this.root = buildTree(characters, 0);
		input.close();
	}
	
	// Build the Prefix Tree
	private Node buildTree(char[] chars, int currentIndex) {
		if(currentIndex==chars.length) {
			return null;
		}
		
		char currentChar=chars[currentIndex];
		Node node = new Node();
		node.character = currentChar;
		
		if (currentChar == '*') {
			node.left=buildTree(chars, currentIndex+1);
			int leftChildrenCount = getSize(node.left);
			node.right=buildTree(chars, currentIndex+leftChildrenCount+1);
		}
		return node;
	}
	
	// the nodes in the subtree rooted at the node argument.
	private int getSize(Node node){
		if (node==null) return 0;
		else return getSize(node.left) + getSize(node.right)+1;
	}
	private void queueString(String inputString) {
		char[] cs = inputString.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			this.queue.add(cs[i]);
		}
		inputString.toCharArray();
	}
	/*
	 * @param none
	 * @return an ArrayList of Encode object.
	 * @will find out and return the encoding (a string representing a sequence of bits) for each character on the leaf node.
	 * @Equivalent to finding all the paths (concatenating the '0' or '1' along the path) to each leaf node.
	 */
	public ArrayList<Encode> getEncodes() {
		// YOUR CODES
		ArrayList<Encode> paths = new ArrayList<>();
		String s = "";
		getEncodesRec(paths,s,root);
		return paths;// For compilation. You need to change it.
	}

	// uncompress the message and compute for the compression ratio.
	// print corresponding message
	// return the compression ratio.

	
	public void getEncodesRec(ArrayList<Encode> paths, String s, Node node) {
		if (node.left == null && node.right == null) {
			paths.add(new Encode(node.character, s));
		} else {
			if (node.left != null) {
				getEncodesRec(paths, s + '0', node.left);
			}
			if (node.right != null) {
				getEncodesRec(paths, s + '1', node.right);
			}
		}
	}

	public double uncompress(String compressedMsg) {
		// YOUR CODES
		String res = "";
		Node current = root;
		for (int i = 0; i < compressedMsg.length(); i++) {
			char c = compressedMsg.charAt(i);
			if (c == '0') {
				current = current.left;
			} else {
				current = current.right;
				// Reach leaf
			}
				if (current.left == null && current.right == null) {
					res += current.character;
					// start over
					current = root;
				}
			}
		

		int uncompressedBits = res.length() * 8;
		int compressedBits = 0;
		ArrayList<Encode> encodes = this.getEncodes();
		for (int x = 0; x < res.length(); x++) {
			char h = res.charAt(x);
			for (int j = 0; j < encodes.size(); j++) {
				if (encodes.get(j).getCharacter() == h) {
					compressedBits += encodes.get(j).getEncode().length();
					break; // for compilation. You need to change it.
				}
			}
		}

		double ratio = (1.0) * compressedBits / uncompressedBits * 100;
		double ratiol = Math.round(ratio * 100) / 100.0;
		System.out.println(res);
		System.out.println("Number of bits if uncompressed = " + uncompressedBits);
		System.out.println("Number of bits = " + compressedBits);
		System.out.println("Number of characters =" + res.length());
		System.out.println("Compression ratio = " + ratio);
		
		return ratiol; // for compilation. You need to change it.
		}

	public static void main(String[] args) throws FileNotFoundException {
		PrefixTree theTree = new PrefixTree();
		theTree.displayTree();

		System.out.println(theTree.getEncodes());
			
		File file = new File("abra.pre");   //read the second line
		Scanner input = new Scanner(file);
		input.nextLine();
		String msg = input.nextLine().trim();
		input.close();
		
		System.out.println("The compression ratio is: " + theTree.uncompress(msg));
	}
}
