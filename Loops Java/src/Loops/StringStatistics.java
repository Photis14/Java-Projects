//Author: John Photis
//Purpose: This Java program outputs facts about the string the user enters.


package Loops;

import java.util.Scanner;

public class StringStatistics {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		
		//String Input from user
		//System.out.print("Please enter a string: ");
		String string= input.nextLine();
		
		
		//Ascii value of first letter
		char c=string.charAt(0); 
		int j=c;
		System.out.println("The ASCII value of the first letter in the string is " + j);
	
	
		char[] ch = string.toCharArray();
		int letters = 0;
		int digits = 0;
		int upper = 0;
		int lower = 0;
		int e = 0;
		int initiate = 0;
		int contain = 0;
		for(int i = 0; i < string.length(); i++){
			char k = string.charAt(i);
			if(k=='e'){
				e++;
			}
			if(Character.isLetter(ch[i])){
				letters++;
			}
			if(Character.isUpperCase(ch[i])){
				upper++;
			}
			else if(Character.isLowerCase(ch[i])){
				lower++;
			}
			else if(Character.isDigit(ch[i])){
				digits++;
			}	
			else if(Character.isDigit(c)){
				digits++;
			}	
			else if(string.charAt(0) != 'A'){
				initiate++;
			}
			else if(string.contains("'tion'")){
					contain++;
			}
		}
		System.out.println("There are " + letters + " alphabetical letters");
		System.out.println("There are " + digits + " digital letters");
		System.out.println("There are " + upper + " upper case letters.");
		System.out.println("There are " + lower + " lower case letters.");
		System.out.println("There are " + e + " 'e's in the string");
		
		
		
		if(initiate>0) {
			System.out.println("The string does not initiate with \'A\'");
		}
			else {
				System.out.println("The string initiates with \'A\'");
		}
	
		if(contain==0) {
			System.out.println("It does not contain a substring as \'tion\'" );
		}	
				
		
	}
}