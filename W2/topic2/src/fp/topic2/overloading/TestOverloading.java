package fp.topic2.overloading;

// Method overloading example by Caspar
// Not to be confused with the OO concept of overriding (@Override) covered later!
public class TestOverloading
{
   public static void main(String[] args)
   {
      double d = 1.0;
      // the compiler can work out which one to call from the param type(s)
      doSomething(1);
      doSomething(1.0F);
      doSomething(1.0);
      // Object (non-primitive type Double) .. try casting to Object to see what happens!
      doSomething(Double.valueOf(1.0));
      // doSomething((Object) Double.valueOf(1.0));
      doSomething("1", Double.valueOf(d));
   }

   private static void doSomething(int x)
   {
      // note that println is itself overloaded .. check API docs to see the many variations!
      System.out.printf("int: %d\n", x);
   }

   private static void doSomething(float x)
   {
      System.out.printf("float: %.2fF\n", x);
   }

   private static void doSomething(double x)
   {
      System.out.printf("double: %.2f\n", x);
   }

   private static void doSomething(Double x)
   {
      System.out.printf("Double: %.2f\n", x);
   }

   // we are not limited to just one parameter
   private static void doSomething(String x, Object y)
   {
      System.out.printf("String: \"%s\", Object (converted to string for display): %s", x, y
         .toString());
   }

   // NOTE: return type is not sufficient to distinguish overloaded methods (uncomment to see for yourself!)
   //	private static int doSomething(int x)
   //	{
   //
   //	}
}
