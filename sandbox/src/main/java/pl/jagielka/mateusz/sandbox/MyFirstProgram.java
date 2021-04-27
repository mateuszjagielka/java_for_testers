package pl.jagielka.mateusz.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("Boczek");

		double l = 5;
		System.out.println(area(l));
		double b = 7;
		System.out.println(area(l, b));

	}
	public static void hello(String somebody) {
		System.out.println("Hello " + somebody + "!");
	}

	public static double area(double len) {
		return len * len;
	}

	public static double area(double a, double b) {
		return a * b;
	}
}