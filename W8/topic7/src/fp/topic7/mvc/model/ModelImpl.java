package fp.topic7.mvc.model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class ModelImpl extends Observable implements Model
{
   private static Model singletonInstance = null;

   private String[] data = new String[Model.NUM_VIEWS];

   // this is a singleton class with a private constructor
   // only way to get reference is with getSingletonInstance() method
   private ModelImpl()
   {

      double sqrt = Math.sqrt(Model.NUM_VIEWS);

      // check that the pre-condition is met
      // need to provide -ea param to VM to enable assertion checking
      assert (sqrt / (int) sqrt) == 1.0 : "PRE: Model.NUM_VIEWS must have int sqrt";
   }

   public static Model getSingletonInstance()
   {
      // lazy instantiation (only when needed)
      if (singletonInstance == null)
         singletonInstance = new ModelImpl();

      return singletonInstance;
   }

   public String getData(int i)
   {
      return data[i];
   }

   public void setData(int i, String data)
   {
      this.data[i] = data;
      // observer notification behaviour
      // (these two methods are inherited from java.util.Observable)
      setChanged();
      // pass the view number as a hint so correct view can be updated
      notifyObservers(i);
   }
}
