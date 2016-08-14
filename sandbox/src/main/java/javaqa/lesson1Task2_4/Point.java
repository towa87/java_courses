package javaqa.lesson1Task2_4;

import org.omg.PortableServer.POA;

/**
 * Created by Антон on 14.08.2016.
 */
public class Point {
  double x;
  double y;

  public Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }
  public static double distance (Point dot1, Point dot2)
  {
    double distance = Math.sqrt((dot2.x - dot1.x)* (dot2.x - dot1.x)  + (dot2.y - dot1.y)* (dot2.y - dot1.y));
    return distance;
  }
}
