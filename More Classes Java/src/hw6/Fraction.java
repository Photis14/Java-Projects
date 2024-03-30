//Author: John Photis
//Due Date: November 1st, 2021
//Purpose: This Java program takes input of both fractions and performs mathematics using all operators between the fractions.
//Credits: I completed this program independently using class notes and the textbook. 

package hw6;

import java.util.*;

public class Fraction {

	public int numerator;
	public int denominator;

	public Fraction() {
		numerator = 1;
		denominator = 1;
	}

	public Fraction(int numerator, int denominator) {
		int factor = greatestcommondivisor(numerator, denominator);
		this.numerator = numerator / factor;
		this.denominator = denominator / factor;
	}

	public void set(int num, int demo) {
		this.numerator = numerator+1;
		this.denominator = denominator+1;
	}

	public Fraction add(Fraction fraction) {
		int addnumerator = (this.numerator * fraction.denominator) + (fraction.numerator * this.denominator);
		int adddenominator = this.denominator * fraction.denominator;
		int factor = greatestcommondivisor(addnumerator, adddenominator);
		int newNumerator = addnumerator / factor;
		int newDenominator = adddenominator / factor;

		Fraction add = new Fraction(newNumerator, newDenominator);

		return add;
	}

	public Fraction subtract(Fraction fraction) {
		int subtractnumerator = (this.numerator * fraction.denominator) - (fraction.numerator * this.denominator);
		int subtractdenominator = this.denominator * fraction.denominator;
		int factor = greatestcommondivisor(subtractnumerator, subtractdenominator);
		int newNumerator = subtractnumerator / factor;
		int newDenominator = subtractdenominator / factor;

		Fraction subtract = new Fraction(newNumerator, newDenominator);

		return subtract;
	}

	public Fraction multiply(Fraction fraction) {
		int multiplynumerator = this.numerator * fraction.numerator;
		int multiplydenominator = this.denominator * fraction.denominator;
		int factor = greatestcommondivisor(multiplynumerator, multiplydenominator);
		int newNumerator = multiplynumerator / factor;
		int newDenominator = multiplydenominator / factor;

		Fraction multiply = new Fraction(newNumerator, newDenominator);

		return multiply;
	}

	public Fraction divide(Fraction fraction) {
		int dividenumerator = this.numerator * fraction.denominator;
		int dividedenominator = this.denominator * fraction.numerator;
		int factor = greatestcommondivisor(dividenumerator, dividedenominator);
		int newNumerator = dividenumerator / factor;
		int newDenominator = dividedenominator / factor;

		Fraction divide = new Fraction(newNumerator, newDenominator);

		return divide;
	}

	public String toString() {
		return "" + this.numerator + "/" + this.denominator;
	}

	public double toDouble() {
		return ((double) this.numerator) / this.denominator;

	}

	public static int greatestcommondivisor(int num1, int num2) {
		if (num1 == 0)
			return num2;
		return greatestcommondivisor(num2 % num1, num1);
	}

	
	
	
	
	
	
//-----------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the numerator and denominator of the first Fraction: ");
		int numerator1 = input.nextInt();
		int denomenator1 = input.nextInt();

		Fraction fraction1 = new Fraction(numerator1, denomenator1);

		System.out.println("The first fraction : " + fraction1);
		System.out.println("It's double value is : " + String.format("%.2f", fraction1.toDouble()));

		System.out.println("\nPlease enter the numerator and denominator of the second Fraction: ");
		int numerator2 = input.nextInt();
		int denomenator2 = input.nextInt();

		Fraction fraction2 = new Fraction(numerator2, denomenator2);

		System.out.println("The second fraction : " + fraction2);
		System.out.println("It's double value is : " + String.format("%.4f", fraction2.toDouble()));
		System.out.println("\n" + fraction1 + " + " + fraction2 + " = " + fraction1.add(fraction2));
		System.out.println(fraction1 + " - " + fraction2 + " = " + fraction1.subtract(fraction2));
		System.out.println(fraction1 + " * " + fraction2 + " = " + fraction1.multiply(fraction2));
		System.out.println(fraction1 + " / " + fraction2 + " = " + fraction1.divide(fraction2));

	}
}