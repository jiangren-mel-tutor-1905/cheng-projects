package liang.chapter9;

public class TestCircleRectangle_Basic_Reuse
{
   public static void main(String[] args)
   {
      Circle circle = new Circle(1);
      GeometricObject geometricObject = circle;
      // not recommended because easy to break
      //geometricObject.getArea(); // won't compile
      ((Circle) (geometricObject)).getArea();
      circle.getArea();
      System.out.println("A circle " + circle.toString());
      System.out.println(circle.getRadius());
      System.out.println("The radius is " + circle.getRadius());
      System.out.println("The area is " + circle.getArea());
      System.out.println("The diameter is " + circle.getDiameter());
      circle.setFilled(true);
      Rectangle rectangle = new Rectangle(2, 4);
      System.out.println("\nA rectangle " + rectangle.toString());
      System.out.println("The area is " + rectangle.getArea());
      System.out.println("The perimeter is " + rectangle.getPerimeter());
   }
}
