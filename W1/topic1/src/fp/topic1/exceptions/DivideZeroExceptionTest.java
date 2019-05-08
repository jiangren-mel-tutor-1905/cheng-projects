package fp.topic1.exceptions;

public class DivideZeroExceptionTest
{
   /**
    * @param args
    */
   public static void main(String[] args)
   {
      // try
      // {
      dividezero();
      // }
      // catch (Exception e)
      // {
      // e.printStackTrace(System.err);
      // }

      // int a = 10;
      // int b = 0;
      // System.out.println(a / b);
      System.out.println("made it to the end of main()");
   }

   public static void dividezero()
   {
      int a = 10;
      int b = 0;

      // try
      // {
      System.out.println(a / b);
      // }
      // catch (Exception e)
      // {
      // e.printStackTrace(System.err);
      // }

   }
}
