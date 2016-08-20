package javaqa.sandBox;

public class MyFirstClass {

  public static void main (String[] args)

{
  hello("world");
  hello("user");
  hello("Anton");

  Square square = new Square(5);

  System.out.println("square area with a side" + square.a + " = " + square.area());

 Rectangle rectangle = new Rectangle(5, 6);

  System.out.println("area of rectangle with sides " + rectangle.a + " and " + rectangle.b + " = " + rectangle.area());

}
  public static void hello (String somebody)
  {
    System.out.println("Hello, " + somebody + "!");
  }



}