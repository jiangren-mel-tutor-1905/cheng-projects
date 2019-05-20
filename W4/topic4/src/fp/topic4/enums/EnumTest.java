package fp.topic4.enums;

// enum class example by Caspar
// based on example in https://docs.oracle.com/javase/8/docs/technotes/guides/language/enums.html 
public class EnumTest
{
   public enum Operation
   {
      // constants with constructor call and override
      PLUS('+')
      {
         @Override
         public int op(int x, int y)
         {
            return x + y;
         }
      },
      MINUS('-')
      {
         @Override
         public int op(int x, int y)
         {
            return x - y;
         }
      },
      MULT('*')
      {
         @Override
         public int op(int x, int y)
         {
            return x * y;
         }
      };

      // attribute
      private char symbol;

      // constructor
      private Operation(char symbol)
      {
         this.symbol = symbol;
      }

      // abstract method to be overridden per constant
      public abstract int op(int x, int y);

      // public method (accessor for attribute)
      public char getSymbol()
      {
         return symbol;
      }
   }

   // Test the Operation enum class
   public static void main(String args[])
   {
      int x = 1;
      int y = 2;
      for (Operation op : Operation.values())
         System.out.printf("%d %c %d = %d%n", x, op.getSymbol(), y, op.op(x, y));
   }
}
