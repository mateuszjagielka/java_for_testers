package pl.jagielka.mateusz.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		Point p1 = new Point(2, 3);
		Point p2 = new Point(3, 7);
		System.out.println("Distance between two points equals: " + p1.distance(p2));
	}
}