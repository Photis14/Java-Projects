//Author: John Photis
//Purpose: This Java program outputs a lottery of a two digit number where the second digit is different form the first. 


package Loops;

import java.util.*;

public class Lottery {

	public static void main(String[] args) {
		Random rand = new Random();
        
		
		double randomnum1 = Math.random() * 10;
        int randomnum = (int)randomnum1;
        System.out.println("The first digit is " + randomnum);
		
        
		int i=0;
		while(i<1) {
				int random=rand.nextInt(10)+0;
				i++;
				System.out.println("The second digit is " + random);
				}
				
	}
}

