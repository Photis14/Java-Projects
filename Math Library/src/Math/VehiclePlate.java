//Author: John Photis
//Purpose: This Java program outputs a random set of numbers and digits to form a license plate. 



package Math;

public class VehiclePlate {

	public static void main(String[] args) {
		
		int firstletter = 65 + (int)(Math.random() * 26);
		int secondletter = 65 + (int)(Math.random() * 26);
		int thirdletter = 65 + (int)(Math.random() * 26);	

		int firstnumber = (int)(Math.random() * 10);
		int secondnumber = (int)(Math.random() * 10);
		int thirdnumber = (int)(Math.random() * 10);
		int fourthnumber = (int)(Math.random() * 10);

		//System.out.println("$java VehiclePlate");
		System.out.println("" + (char)(firstletter) + ((char)(secondletter)) + ((char)(thirdletter)) 
				+ firstnumber + secondnumber + thirdnumber + fourthnumber);

	}

}
