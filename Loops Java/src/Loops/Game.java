//Author: John Photis
//Purpose: This Java program outputs the classic game of rock paper scissors. 



package Loops;

import java.util.*;

public class Game {

	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		   int rock = 0;
	       int paper = 1;
	       int scissors = 2;
	       int user = 0;
	       int cpu = 0;
	       int games = 0;

	  //User vs. CPU loop
	  while (games < 3) {
	        System.out.println("Rock(0), Paper(1), Scissors(2): ");
	        String userinput = input.nextLine();

	        int inputint = Integer.valueOf(userinput);
	        int cpuinput = (int)(Math.random()*3);

	       if (cpuinput == 1 && inputint == 0){
	           System.out.println("You are rock");
	           System.out.println("Computer is paper");
	           System.out.println("The computer won!");
	           games++;
	           cpu++;
	       }
	       else if (inputint == 1 && cpuinput == 0)
	       { 
	           System.out.println("You are paper");
	           System.out.println("Computer is rock");
	           System.out.println("You win!");
	           games++;
	           user++;
	       }
	     if (cpuinput == 0 && inputint == 2){
	         System.out.println("You are scissors");
	         System.out.println("Computer is rock");
	         System.out.println("The computer won!");
	         games++;
	         cpu++;
	     }
	     else if (inputint == 0 && cpuinput == 2)
	     {
	         System.out.println("You are scissors");
	         System.out.println("Computer is rock");
	         System.out.println("You Win!");
	         games++;
	         user++;
	     }

	     if (cpuinput == 2 && inputint == 1){
	         System.out.println("You are paper");
	         System.out.println("Computer is scissors");
	         System.out.println("The computer won!");
	         games++;
	         cpu++;
	     }
	     else if (inputint == 2 && cpuinput == 1 )
	     {
	         System.out.println("You are scissors");
	         System.out.println("Computer is paper");
	         System.out.println("You Win!");
	         games++;
	         user++;
	     }

	     
	     //Tie portion
	     if (cpuinput == 0 && inputint == 0){
	         System.out.println("You are rock");
	         System.out.println("Computer is rock");
	         System.out.println("Tie!");

	     }
	     if (cpuinput == 1 && inputint == 1){
	         System.out.println("You are paper");
	         System.out.println("Computer is paper");
	         System.out.println("Tie!");

	     }
	     if (cpuinput == 2 && inputint == 2){
	         System.out.println("You are scissors");
	         System.out.println("Computer is scissors");
	         System.out.println("Tie!");
	     }
	     
	     //Game Over Output
	     if(games == 3)  
	    	  System.out.println("Game Over!");
	         }
		
        
        
        
        
        
        
	}
}