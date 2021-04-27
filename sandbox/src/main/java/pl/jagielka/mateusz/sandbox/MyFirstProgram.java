package pl.jagielka.mateusz.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("Boczek");

		Square s = new Square(5);

		double l = 5;
		System.out.println("Area of square with " + s.l + " sides = " + area(s));

		Rectangle r = new Rectangle(5, 6);

		System.out.println("Area of rectangle with sides: " + r.a + " and " + r.b +" = " + area(r));

	}
	public static void hello(String somebody) {
		System.out.println("Hello " + somebody + "!");
	}

	public static double area(Square s) {
		return s.l * s.l;
	}

	public static double area(Rectangle r) {
		return r.a * r.b;
	}
}