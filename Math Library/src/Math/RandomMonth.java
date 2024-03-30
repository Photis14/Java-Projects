//Author: John Photis
//Purpose: This Java program outputs a random number that corresponds to one of the 12 months.



package Math;

public class RandomMonth {

	public static void main(String[] args) {
		int month = (int)((Math.random() * 12) + 1);

		switch (month)
		{
			case 1: 
				System.out.println("The random number generated is 1"); 
				System.out.println("The corresponding month is January.");
			break;
			case 2: 
				System.out.println("The random number generated is 2"); 
				System.out.println("The corresponding month is February."); 
			break;
			case 3: 
				System.out.println("The random number generated is 3"); 
				System.out.println("The corresponding month is March."); 
			break;
			case 4: 
				System.out.println("The random number generated is 4"); 
				System.out.println("The corresponding month is April."); 
			break;
			case 5: 
				System.out.println("The random number generated is 5"); 
				System.out.println("The corresponding month is May."); 
			break;
			case 6: 
				System.out.println("The random number generated is 6"); 
				System.out.println("The corresponding month is June."); 
			break;
			case 7: 
				System.out.println("The random number generated is 7"); 
				System.out.println("The corresponding month is July."); 
			break;
			case 8: 
				System.out.println("The random number generated is 8"); 
				System.out.println("The corresponding month is August."); 
			break;
			case 9: 
				System.out.println("The random number generated is 9"); 
				System.out.println("The corresponding month is September."); 
			break;
			case 10: 
				System.out.println("The random number generated is 10"); 
				System.out.println("The corresponding month is October."); 
			break;
			case 11: 
				System.out.println("The random number generated is 11"); 
				System.out.println("The corresponding month is November."); 
			break;
			case 12: 
				System.out.println("The random number generated is 12"); 
				System.out.println("The corresponding month is December.");

	}
	}
}
