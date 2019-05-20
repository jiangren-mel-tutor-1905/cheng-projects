package fp.topic4.generic;

import java.util.HashMap;
import java.util.Map;

public class TestGenericMap
{
   public static void main(String[] args)
   {
      String one = new String("one");
      String two = new String("one");

      System.out.println(one == two);
      Map<String, Account> map = new HashMap<String, Account>();

      map.put("account1", new Account("account1", "S123", 130.0));
      map.put("account2", new Account("account2", "S124", 90.0));
      // will cause a compile error due to type mismatch
      //map.put(Integer.valueOf(1234), new Account("account3", "S126", 220.0));
      //		map.put("string", new String("account3"));
      Account acc = map.get("account1");
      System.out.println(acc.getName());
      System.out.println("Entries in Map");
      displayMap(map);
   }

   //   public static void displayMap(Map<String, Account> m)
   //   {
   //      for (String k : m.keySet())
   //         System.out.printf("%s:%s\n", k, m.get(k));
   //   }

   // can do it with a generic utility method
   public static <K, V> void displayMap(Map<K, V> m)
   {
      for (K k : m.keySet())
         System.out.printf("%s:%s\n", k, m.get(k));
   }
}
