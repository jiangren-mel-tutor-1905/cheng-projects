package liang.chapter10;

public abstract class GeometricObject
{
   private String color = "white";

   private boolean filled;

   private java.util.Date dateCreated;

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

   public java.lang.String getColor()
   {
      return color;
   }

   public void setColor(java.lang.String color)
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

   public String toString()
   {
      return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
   }

   // public int compareTo(Object o2) {
   // double area1 = this.getArea();
   // double area2 = ((GeometricObject)o2).getArea();
   //
   // if (area1 < area2)
   // return -1;
   // else if (area1 == area2)
   // return 0;
   // else
   // return 1;
   // }

   public abstract double getArea();

   public abstract double getPerimeter();
}