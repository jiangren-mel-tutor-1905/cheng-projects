package mvc.model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class ModelImpl extends Observable implements Model
{
   private static Model singletonInstance = new ModelImpl();

   // this contains the color of individual views (Circle icons)
   private Color[] colorData = new Color[Model.NUM_VIEWS];

   // this is a singleton class with a private constructor
   // only way to get reference is with getSingletonInstance() factory method
   private ModelImpl()
   {
      double sqrt = Math.sqrt(Model.NUM_VIEWS);

      // check that the pre-condition is met
      if (sqrt / (int) sqrt != 1.0)
         throw new IllegalArgumentException("NUM_VIEWS must have int sqrt()");

      // assign random colors to our data
      for (int i = 0; i < colorData.length; i++)
         colorData[i] = Color.values()[(int) (Math.random() * Color.values().length)];
   }

   public static Model getSingletonInstance()
   {
      return singletonInstance;
   }

   @Override
   public Color getColor(int i)
   {
      return colorData[i];
   }

   @Override
   public void setColor(int i, Color color)
   {
      this.colorData[i] = color;
      // observer notification behaviour
      // (these two methods are inherited from java.util.Observable)
      setChanged();
      // pass the view number as a hint so correct view
      // can be updated
      notifyObservers(i);
   }
}
