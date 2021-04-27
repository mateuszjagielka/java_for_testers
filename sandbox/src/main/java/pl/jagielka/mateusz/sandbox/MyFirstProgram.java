package pl.jagielka.mateusz.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		Point p1 = new Point(2, 3);
		Point p2 = new Point(5, 7);
		System.out.println("Distance between two points equals: " + distance(p1, p2));
	}

	public static double distance(Point p1, Point p2) {
		double x = p1.x - p2.x;
		double y = p1.y - p2.y;
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}