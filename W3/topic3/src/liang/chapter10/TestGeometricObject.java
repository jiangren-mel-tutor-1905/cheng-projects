package liang.chapter10;

public class TestGeometricObject
{
   public static void main(String[] args)
   {
      // non-polymorphic
      Circle c = new Circle(5);
      Rectangle r = new Rectangle(5, 3);
      r.getPerimeter();
      c.getPerimeter();

      // Declare and initialize some geometric objects
      Circle circle = new Circle(5);

      GeometricObject geoObjectArray[] = new GeometricObject[] { circle, new Rectangle(5, 3) };

      // circles only
      Circle circleArray[] = new Circle[] { circle };

      System.out.println("The two objects have the same area? " + equalArea(geoObjectArray[0], geoObjectArray[1]));

      // Display first GeometricObject
      displayGeometricObject(geoObjectArray[0]);

      // Display second GeometricObject
      displayGeometricObject(geoObjectArray[1]);

      // polymorphism in action
      for (int i = 0; i < geoObjectArray.length; i++)
         System.out.println(geoObjectArray[i].getPerimeter());

      // not the best strategy! (see loop below)
      if (geoObjectArray[0] instanceof Circle)
         ((Circle) geoObjectArray[0]).getRadius();

      // do something special only to the circles
      for (Circle aCircle : circleArray)
         System.out.println(aCircle.getRadius());

   }

   /** A method for comparing the areas of two geometric objects */
   public static boolean equalArea(GeometricObject object1, GeometricObject object2)
   {
      return object1.getArea() == object2.getArea();
   }

   /** A method for displaying a geometric object */
   public static void displayGeometricObject(GeometricObject object)
   {
      System.out.println();
      System.out.println("The area is " + object.getArea());
      System.out.println("The perimeter is " + object.toString());
   }
}
