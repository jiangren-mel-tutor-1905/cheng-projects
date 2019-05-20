package liang.chapter10.refactored;

@SuppressWarnings({"rawtypes", "unchecked"})
//Max.java: Find a maximum object
public class Max
{

   /** Return the maximum of two objects */
   public static Comparable max(Comparable o1, Comparable o2)
   {

      if (o1.compareTo(o2) > 0)
         return o1;
      else
         return o2;
   }
}
