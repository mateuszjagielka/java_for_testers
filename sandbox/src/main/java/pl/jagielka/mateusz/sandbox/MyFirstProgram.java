package pl.jagielka.mateusz.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("Boczek");

		Square s = new Square(5);

		System.out.println("Area of square with " + s.l + " sides = " + s.area());

		Rectangle r = new Rectangle(5, 6);

		System.out.println("Area of rectangle with sides: " + r.a + " and " + r.b +" = " + r.area());

	}
	public static void hello(String somebody) {
		System.out.println("Hello " + somebody + "!");
	}

}