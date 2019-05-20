package fp.topic4.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Simple Iterator demo for element deletion by Caspar
public class IteratorTest
{
   // suppress warnings since we are not looking at generics yet
   @SuppressWarnings({ "unchecked", "rawtypes" })
   public static void main(String[] args)
   {
      // there is no Array[] or variable length argument constructor for ArrayList 
      // but as usual in Java we can find a way :)
      // NOTE: if we didn't construct a new ArrayList and simply assigned the return it would be a fixed sized List
      List list = new ArrayList(Arrays.asList("one", "two", "three"));
      list.add("four");

      System.out.printf("Before: %d elements in list\n", list.size());

      // causes ConcurrentModificationException!
      //            for (Object o : list)
      //               list.remove(o);

      //this won't exception and looks like it could work but doesn't because the indexes get changed as you loop!
      //      for (int i = 0; i < list.size(); i++)
      //         list.remove(i);

      // in reverse order works but a bit of a hack!
      //      for (int i = list.size() - 1; i >= 0; i--)
      //         list.remove(i);

      // but we can safely remove through an iterator

      Iterator iterator = list.iterator();
      while (iterator.hasNext())
      {
         // need to move to next element so we can remove
         iterator.next();
         iterator.remove();
      }
      System.out.printf("After: %d elements in list\n", list.size());
   }
}
