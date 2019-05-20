package liang.chapter9;

public class Test {
  public static void main(String[] args) {
    Circle circle = new Circle(1);
    System.out.println(circle.toString());
    System.out.println("The radius is " + circle.getRadius());
    System.out.println("The area is " + circle.getArea());
    System.out.println("The diameter is " + circle.getDiameter());
  }
}
