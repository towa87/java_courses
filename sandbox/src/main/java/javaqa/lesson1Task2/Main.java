package javaqa.lesson1Task2;

/**
 * Created by Антон on 14.08.2016.
 */
public class Main {

  public static void main (String[] args)
  {
    Point dot1 = new Point(-3, 60);
    Point dot2 = new Point(7.5, 500);
    System.out.println("A distance between 2 dots is " + distance(dot1, dot2));
  }

 public static double distance (Point dot1, Point dot2)
 {
     double distance = Math.sqrt((dot2.x - dot1.x)* (dot2.x - dot1.x)  + (dot2.y - dot1.y)* (dot2.y - dot1.y));
   return distance;
 }
}
