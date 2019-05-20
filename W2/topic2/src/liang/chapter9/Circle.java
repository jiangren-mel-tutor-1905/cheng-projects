package liang.chapter9;

import java.util.Date;

public class Circle extends GeometricObject
{
   private double radius;

   public Circle()
   {
      this(1.0);
   }

   public Circle(Date date, String color, boolean filled, double radius)
   {
      this(date, color, radius, filled);
   }

   public Circle(Date date, String color, double radius, boolean filled)
   {
      super(date, color, filled);
      this.radius = radius;
   }

   public Circle(double radius)
   {
      //super(); // will be invoked automatically anyway
      this.radius = radius;
   }

   /** Return radius */
   public double getRadius()
   {
      return radius;
   }

   /** Set a new radius */
   public void setRadius(double radius)
   {
      this.radius = radius;
   }

   /** Return area */
   public double getArea()
   {
      return radius * radius * Math.PI;
   }

   /** Return diameter */
   public double getDiameter()
   {
      return 2 * radius;
   }

   /** Return perimeter */
   public double getPerimeter()
   {
      return 2 * radius * Math.PI;
   }

   /** Print the circle info */
   public void printCircle()
   {
      System.out.println("The circle is created " + super.getDateCreated() + " and the radius is "
         + radius);
   }

   // added by Caspar as an example of over-riding
   @Override
   public Date getDateCreated()
   {
      // use the superclass behaviour
      Date created = super.getDateCreated();

      // but do something specialised
      Date now = new java.util.Date();
      return (now.compareTo(created) != 0) ? now : created;
   }

   // added by Caspar for polymorphism demo
   @Override
   public String toString()
   {
      // adapted from printCircle();
      return String.format("The circle was %s and the radius is %s", super.toString(), radius);
   }
}
