package fp.topic4.notgeneric;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestMap
{
   public static void main(String[] args)
   {
      Map map = new HashMap();

      map.put("account1", new Account("account1", "S123", 130.0));
      map.put("account2", new Account("account2", "S124", 90.0));
      // next line will cause class cast exception
      //map.put("account1", new String("account1"));

      Account acc = (Account) map.get("account1");
      System.out.println(acc.getName());
      System.out.println("Entries in Hashmap");
      displayMap(map);
   }

   public static void displayMap(Map map)
   {
      // could use map.values() to retrieve all the Account objects
      Set keySet = map.keySet();
      Iterator iterator = keySet.iterator();
      while (iterator.hasNext())
      {
         String key = (String) iterator.next();
         System.out.println(key + ":" + map.get(key));
      }
   }
}
