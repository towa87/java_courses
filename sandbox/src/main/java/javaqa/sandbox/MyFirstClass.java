package javaqa.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyFirstClass {

  public static void main (String[] args)

{
  hello("world");
  hello("user");
  hello("Anton");

  Square square = new Square(5);

  System.out.println("square area with a side" + square.a + " = " + area(square.a));

 Rectangle rectangle = new Rectangle(5, 6);

  System.out.println("area of rectangle with sides " + rectangle.a + " and " + rectangle.b + " = " + area(rectangle.a, rectangle.b));

}
  public static void hello (String somebody)
  {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area (double l)
  {
    return l*l;
  }
  public static  double area(double a, double b)
  {
    return a * b;
  }
}