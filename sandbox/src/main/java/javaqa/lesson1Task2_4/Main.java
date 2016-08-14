package javaqa.lesson1Task2_4;

/**
 * Created by Антон on 14.08.2016.
 */
public class Main {
  public static void main(String[] args) {
    Point dot1 = new Point(15, 60);
    Point dot2 = new Point(7.5, 999);
    System.out.println("A distance between 2 dots is " + Point.distance(dot1, dot2));
  }
}
