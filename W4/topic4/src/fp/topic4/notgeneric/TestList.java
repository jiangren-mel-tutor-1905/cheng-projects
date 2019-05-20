package fp.topic4.notgeneric;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestList
{
   public static void main(String[] args)
   {
      List accList = new ArrayList();
      // List accList = new Vector();
      accList.add(new Account("1", "joe", 100.0));
      accList.add(new Account("2", "jane", 101.0));
      //accList.add(new Customer());

      List custList = new LinkedList();
      custList.add(0, new Customer());
      custList.add(1, new Customer());
      //custList.add(new Account("3", "jojo", 100.0));

      Iterator iter = accList.iterator();
      while (iter.hasNext())
      {
         // do what you want to obj1 (note the problematic cast!)
         System.out.println(((Account) iter.next()).getName());
      }

      System.out.println("Entries in accList =" + accList);
      System.out.println("Entries in custList =" + custList);
   }
}
