package fp.topic4.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp.topic4.notgeneric.Account;

public class TestGenericList
{
   public static void main(String[] args)
   {
      List<Account> accList = new LinkedList<Account>();
      // List accList = new Vector();
      accList.add(new Account("1", "joe", 100.0));
      accList.add(new Account("2", "jane", 101.0));
      //accList.add(new Customer());

      List<Customer> custList = new ArrayList<Customer>();
      custList.add(new Customer());
      custList.add(new Customer());
      //custList.add(new Account("3", "jojo", 101.0));

      Iterator<Account> iter = accList.iterator();
      while (iter.hasNext())
      {
         // do what you want to obj1 (note the problematic cast!)
         System.out.println(iter.next().getName());
      }

      for (Customer cust : custList)
         System.out.println(cust.getName());

      System.out.println("Entries in accList =" + accList);
      System.out.println("Entries in custList =" + custList);

   }
}
