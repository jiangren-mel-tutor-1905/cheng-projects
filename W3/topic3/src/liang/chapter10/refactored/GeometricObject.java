package liang.chapter10.refactored;

public interface GeometricObject
{

   public abstract java.lang.String getColor();

   void setColor(java.lang.String color);

   boolean isFilled();

   void setFilled(boolean filled);

   java.util.Date getDateCreated();

   double getArea();

   double getPerimeter();

}