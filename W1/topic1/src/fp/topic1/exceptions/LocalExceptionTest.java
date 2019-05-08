package fp.topic1.exceptions;

public class LocalExceptionTest
{
   private static void numberTest(int num)
   {
      boolean valid = false;

      try
      {
         if (num < 0 || num > 9)
            throw new RangeException("out of range");
         else
            valid = true;
      }
      // specialised exceptions must come first (otherwise the abstract
      // exception will always get caught)
      catch (RangeException e)
      {
         System.out.println(e.getMessage());
      }
      finally
      {
         System.out.println("always do this");
      }

      if (valid)
         System.out.println("valid data");
      System.out.println();
   }

   public static void main(String args[])
   {
      numberTest(5);
      numberTest(12);
      numberTest(0);
      numberTest(-1);
   }
}
