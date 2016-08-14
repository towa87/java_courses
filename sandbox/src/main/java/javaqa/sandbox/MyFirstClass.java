package javaqa.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyFirstClass {

  public static void main (String[] args)

{
  hello("world");
  hello("user");
  hello("Anton");

  double l = 5;
  System.out.println("square area with a side" + l + "=" + area(l));

  double a = 6;
  double b = 7;
  System.out.println("area of rectangle with sides " + a + " è " + b + " = " + area(a,b));

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