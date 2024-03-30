//Author: John Photis
//Purpose: This Java program follows the Triangle Class.


package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

abstract class SimpleGeometric {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	/** Construct a default geometric object */
	protected SimpleGeometric() {
		dateCreated = new java.util.Date();
	}

	/** Construct a geometric object with color and filled value */
	protected SimpleGeometric(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	/** Return color */
	public String getColor() {
		return color;
	}

	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Return filled. Since filled is boolean, the get method is named isFilled
	 */
	public boolean isFilled() {
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	/** Return a string representation of this object */
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}

	/** Abstract method getArea */
	// abstract method has no implementation, no method body
	public abstract double getArea();

	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
}

public class Triangle extends SimpleGeometric {

    private double side1;
    private double side2;
    private double side3;


    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        isValidTriangle();
    }

    public Triangle() {
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }

    @Override
    public double getArea() {

        double s = (side1 + side2 + side3) / 2.0;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }

    public static boolean isTriangle(double side1, double side2, double side3) {

        return  ((side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side3 + side2 > side1));

    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) throws IllegalTriangleException {
        this.side1 = side1;
        isValidTriangle();
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) throws IllegalTriangleException{
        this.side2 = side2;
        isValidTriangle();
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) throws IllegalTriangleException {
        this.side3 = side3;
        isValidTriangle();
    }

    private void isValidTriangle() throws IllegalTriangleException{
        if (!isTriangle(side1, side2, side3)) {
            throw new IllegalTriangleException(side1, side2, side3);
            
        }
        System.out.println("The perimeter of this triangle is " + String.format("%.0f",getPerimeter()));
        
    }

    public class IllegalTriangleException extends IllegalArgumentException {

        private double s1;
        private double s2;
        private double s3;

         public IllegalTriangleException(double s1, double s2, double s3) {
            super("Invalid Triangle");
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        public double getS1() {
            return s1;
        }

        public double getS2() {
            return s2;
        }

        public double getS3() {
            return s3;
        }


    }



    public static void main(String[] args) throws IOException {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Please enter the three sides of a triangle: ");
    	BufferedReader in = new BufferedReader( 
    			new InputStreamReader( 
    			System.in)); 

    			String[] input1 = new String[3]; 
    			int a; 
    			int b; 
    			int c; 
    			input1 = in.readLine().split(" "); 

    			a = Integer.parseInt(input1[0]); 
    			b = Integer.parseInt(input1[1]); 
    			c = Integer.parseInt(input1[2]);
        Triangle t1;
        try {
            t1 = new Triangle(a, b, c);
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
        

    }

}
