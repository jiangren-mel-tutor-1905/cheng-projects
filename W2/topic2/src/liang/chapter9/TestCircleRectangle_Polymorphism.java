package liang.chapter9;

// Liang code modified by Caspar for more realistic Polymorphism demo
public class TestCircleRectangle_Polymorphism
{
   public static void main(String[] args)
   {
      GeometricObject circle = new Circle(1);
      GeometricObject shape = new Rectangle("white", 2, 4);
      GeometricObject go[] = new GeometricObject[] { shape, new Octagon(), circle };

      System.out.println("Polymorphic iteration through the superclass type");

      for (int i = 0; i < go.length; i++)
      {
         // polymorphically call toString() method 
         System.out.println(go[i].toString());
         // how can we make this work?
         //System.out.println(go[i].getPerimeter());

         // abstract class example in chapter 10 shows how to avoid instanceof check
         if (go[i] instanceof Circle)
            System.out.println(((Circle) go[i]).getRadius());
      }

      //((Rectangle) circle).getPerimeter(); // ClassCastException
   }
}
