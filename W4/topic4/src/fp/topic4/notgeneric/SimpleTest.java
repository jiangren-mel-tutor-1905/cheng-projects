package fp.topic4.notgeneric;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// see http://help.eclipse.org/kepler/index.jsp?topic=/org.eclipse.jdt.doc.user/tasks/task-suppress_warnings.htm
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SimpleTest
{
   public static void main(String args[])
   {
      String[] strings = new String[] { "one", "two" };

      for (String str : strings)
         System.out.println(str);
      System.out.println();

      List list = new ArrayList<>();

      // add elements to list without an index
      list.add("one");
      list.add(new String("two"));

      // add to a specific index (need to use List interface)
      list.add(2, "three");
      // back to adding at end
      list.add("four");
      list.add(4, new String("five"));
      list.add(5, "six");

      // traverse using for each syntax
      for (Object element : list)
         System.out.println(element);

      // System.exit(0);

      System.out.println();

      // can use indexes for iteration
      for (int i = 0; i < list.size(); i++)
         System.out.println(list.get(i));

      System.out.println();

      // traverse using iterator
      Iterator iter = list.iterator();
      boolean first = true;
      while (iter.hasNext())
      {
         if (first)
         {
            iter.next();
            // optional operation .. let's see if it is supported!
            // some API detective work shows it will work for LinkedList
            // (trace from AbstractList.remove())
            iter.remove();
            first = false;
            System.out.println("removed first element");
         }
         else
            System.out.println(iter.next());
      }

      System.out.println();

      // traverse using for syntax
      for (Iterator iter2 = list.iterator(); iter2.hasNext();)
         System.out.println(iter2.next());

      System.out.println();
      System.out.println("Java 8 lambda");

      // Java 8 lambdas (explore via tutorials if you are interested in these
      // features but not readily applicable to assignment)
      // https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
      list.forEach(item -> System.out.println(item));
      // list.forEach(System.out::println);
   }
}
