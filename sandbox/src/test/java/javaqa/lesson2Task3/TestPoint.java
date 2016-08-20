package javaqa.lesson2Task3;

import javaqa.lesson1Task2_4.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Антон on 20.08.2016.
 */
public class TestPoint {
@Test
  public void testDistanceZero() {

    Point point_1 = new Point(0,0);
    Point point_2 = new Point(0,0);
    Assert.assertEquals(Point.distance(point_1,point_2), 0.0);
  }
  @Test
  public void testDistanceHugeNumbers () {
    Point point_3 = new Point(100000000, -100000000);
    Point point_4 = new Point(-99999999, 99999999);
    Assert.assertEquals(Point.distance(point_3, point_4), 282842711.0604054473872426960);
  }
  @Test
  public void testDistanceSmallNumbers () {
    Point point_5 = new Point(0.00000001, -0.00000001);
    Point point_6 = new Point(-0.99999999, 0.99999999);
    Assert.assertEquals(Point.distance(point_5, point_6), 1.4142135623730951);
  }
}
