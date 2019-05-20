package liang.chapter9;

public class GeometricObject
{
   private String color = "white";

   private boolean filled;

   private java.util.Date dateCreated;

   /** Construct a default geometric object */
   public GeometricObject()
   {
      this(new java.util.Date());
      filled = true;
   }

   public GeometricObject(String color)
   {
      this(); // added by caspar since date created must always be set
      this.color = color;
   }

   public GeometricObject(java.util.Date date)
   {
      dateCreated = date;
   }

   public GeometricObject(java.util.Date date, String color)
   {
      this(date);
      this.color = color;
   }

   public GeometricObject(java.util.Date date, String color, boolean filled)
   {
      this(date, color);
      this.filled = filled;
   }

   public String getColor()
   {
      return color;
   }

   public void setColor(String color)
   {
      this.color = color;
   }

   public boolean isFilled()
   {
      return filled;
   }

   public void setFilled(boolean filled)
   {
      this.filled = filled;
   }

   public java.util.Date getDateCreated()
   {
      return dateCreated;
   }

   /** Return a string representation of this object */
   @Override
   public String toString()
   {
      return String.format("created on %s\ncolor: %s and filled: %s", dateCreated, color, filled);
   }

   // public double getArea()
   // {
   // return 0.0;
   // }

   //   public double getPerimeter()
   //   {
   //      throw new UnsupportedOperationException("Must override");
   //   }
}
