package liang.chapter10.refactored;

public class Rectangle extends AbstractGeometricObject
{
   private double width;

   private double height;

   public boolean isFilled()
   {
      return true;

   }

   public Rectangle(double width, double height)
   {
      super();
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
   @Override
   public double getArea()
   {
      return width * height;
   }

   /** Return perimeter */
   @Override
   public double getPerimeter()
   {
      return 2 * (width + height);
   }

   // added by Caspar for polymorphism demo
   @Override
   public String toString()
   {
      return "The Rectangle is created " + getDateCreated() + " and the perimeter is " + getPerimeter();
   }
}
