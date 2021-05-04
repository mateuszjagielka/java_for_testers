package pl.jagielka.mateusz.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void distanceTest1() {
    Point p1 = new Point(3,7);
    Point p2 = new Point(4,7);
    Assert.assertEquals(p1.distance(p2), 1);
  }

  @Test
  public void distanceTest2() {
    Point p1 = new Point(4,3);
    Point p2 = new Point(4,7);
    Assert.assertEquals(p1.distance(p2), 4);
  }

  @Test
  public void distanceTest3() {
    Point p1 = new Point(4,3);
    Point p2 = new Point(7,7);
    Assert.assertEquals(p1.distance(p2), 5);
  }

  @Test
  public void distanceTest4() {
    Point p1 = new Point(2,3);
    Point p2 = new Point(3,7);
    Assert.assertEquals(p1.distance(p2), 4.123105625617661);
  }
}
