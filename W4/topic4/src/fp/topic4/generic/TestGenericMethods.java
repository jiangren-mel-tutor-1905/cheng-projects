package fp.topic4.generic;

public class TestGenericMethods
{
   public static <T> T getMid(T[] a)
   {
      return a[a.length / 2];
   }

   public static <T> T getLast(T[] a)
   {
      return a[a.length - 1];
   }

   public static <T> void print(T[] a)
   {
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();
   }

   public static void main(String args[])
   {
      String s[] = { "Apples", "Oranges", "Grapes" };
      Integer nums[] = { 30, 40, 50, 90, 80 };

      // explicit generic type String
      String midS = TestGenericMethods.<String> getMid(s);
      // inferred generic type Integer
      Integer midN = getMid(nums);
      String lastS = getLast(s);
      // types don't match .. compile error
      //Integer lastNum = TestGenericMethods.<String> getLast(nums);
      Integer lastNum = TestGenericMethods.<Integer> getLast(nums);

      System.out.println("Mid String = " + midS);
      System.out.println("Mid Number = " + midN);
      System.out.println("Last String = " + lastS);
      System.out.println("Last Number = " + lastNum);
      System.out.println("** Testing Generic print **");
      // explicit type T (String)
      TestGenericMethods.<String> print(s);
      // inferred type T (Integer)
      print(nums);
   }
}
