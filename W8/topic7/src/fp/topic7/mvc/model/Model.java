package fp.topic7.mvc.model;

import java.util.Observer;

@SuppressWarnings("deprecation")
public interface Model
{
   // PRE-CONDITION: set this to a value with an an integer square root
   public static final int NUM_VIEWS = 16;

   public void setData(int i, String data);

   public String getData(int i);

   public void addObserver(Observer o);
}
