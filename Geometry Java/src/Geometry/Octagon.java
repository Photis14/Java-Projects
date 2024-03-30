//Author: John Photis
//Purpose: This Java program follows the UML of the Octagon class.


package Geometry;

public class Octagon extends GeometricObject implements Comparable<Octagon> {

    private double side;

    public Octagon(double side) {
        this.side = side;
    }
    
	public Octagon(String color, boolean filled, double side) {
	}
	
	public double getPerimeter() {
        return side * 8;
    }
	
	public double getArea() {
        return (2 + (4 / (Math.sqrt(2))) * side * side); 
    }

    public String toString() {
        return "Area: " + getArea() + "\nPerimeter: " + getPerimeter();
    }

    public int compareTo(Octagon octagon) {
        if(getArea() > octagon.getArea()) 
            return 1;
        else if(getArea() < octagon.getArea()) 
                return -1;
        else
            return 0;
    }

}
