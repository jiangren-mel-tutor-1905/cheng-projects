package liang.chapter9;

import java.util.Date;

public class Rectangle extends GeometricObject
{
   private double width;

   private double height;

   public Rectangle()
   {
      // explicit constuctor call
      super(new Date());
   }

   public Rectangle(double width, double height)
   {
      this.width = width;
      this.height = height;
   }

   public Rectangle(String color, double width, double height)
   {
      super(color);
      // setColor(color);
      this.width = width;
      this.height = height;
   }

   /** Return width */
   public double getWidth()
   {
      return width;
   }

   /** Set a new width */
   public void setWidth(double width)
   {
      this.width = width;
   }

   /** Return height */
   public double getHeight()
   {
      return height;
   }

   /** Set a new height */
   public void setHeight(double height)
   {
      this.height = height;
   }

   /** Return area */
   public double getArea()
   {

      return width * height;
   }

   /** Return perimeter */
   public double getPerimeter()
   {
      return 2 * (width + height);
   }

   // added by Caspar for polymorphism demo
   @Override
   public String toString()
   {
      return String.format("The Rectangle was %s and the perimeter is %s", super.toString(),
         getPerimeter());
   }
}
