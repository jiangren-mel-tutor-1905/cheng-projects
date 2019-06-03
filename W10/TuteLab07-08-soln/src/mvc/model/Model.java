package mvc.model;

import java.util.Observer;

@SuppressWarnings("deprecation")
public interface Model
{
   // PRE-CONDITION: set this to a value with an an integer square root
   public static final int NUM_VIEWS = 16;

   // color is really view-oriented data but we
   // treat it as model data for MVC example purposes (this is what we call a View Model!)
   public enum Color
   {
      BLUE, GREEN, ORANGE, RED, YELLOW
   };

   public void setColor(int i, Color color);

   public Color getColor(int i);

   public void addObserver(Observer o);
}
