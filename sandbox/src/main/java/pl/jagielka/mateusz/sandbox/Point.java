package pl.jagielka.mateusz.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point secondPoint) {
    double xDistance = this.x - secondPoint.x;
    double yDistance = this.y - secondPoint.y;
    return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
  }
}
