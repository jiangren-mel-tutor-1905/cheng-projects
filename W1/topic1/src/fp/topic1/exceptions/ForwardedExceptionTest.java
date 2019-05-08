package fp.topic1.exceptions;

public class ForwardedExceptionTest
{
   private static void numberTest(int num) throws RangeException
   {
      if (num < 0 || num > 9)
         throw new RangeException("Number out of Range");
      else
         System.out.printf("A valid number was entered: %d\n", num);
   }

   public static void main(String args[])
   {
      try
      {
         numberTest(5);
         numberTest(12);
         numberTest(0);
         numberTest(-1);
      }
      catch (RangeException e)
      {
         System.out.println(e.getMessage());
      }
      finally
      {
         // try once more (usually we would loop instead)
         try
         {
            numberTest(5);
            numberTest(12);
            numberTest(0);
            numberTest(-1);
         }
         catch (RangeException e)
         {
            System.out.println(e.getMessage());
         }
         System.out.println("Do this whatever happens");
      }
   }
}
