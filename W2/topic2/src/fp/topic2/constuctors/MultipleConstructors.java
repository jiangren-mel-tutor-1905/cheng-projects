package fp.topic2.constuctors;

/**
 * Example showing multiple constructors. Each constructor calls another
 * constructor and then does its own extra bit
 * 
 * @author Caspar Ryan
 * 
 */

@SuppressWarnings("unused")
class E
{
   private int a;
   private int b;
   private int c;
   private int d;

   public E()
   {
      this(1, 2, 3, 4);
   }

   public E(int a)
   {
      // implicitly call super()
      this.a = a;
   }

   // constructors could have extra code such as validation
   // so do not want to duplicate it
   public E(int a, int b)
   {
      this(a);
      this.b = b;
   }

   public E(int a, int b, int c)
   {
      this(a, b);
      this.c = c;
   }

   public E(int a, int b, int c, int d)
   {
      this(a, b, c);
      this.d = d;
   }

   // cut and paste alternative (not recommended because doesn't scale)
   public E(int a, int b, int c, int d, int dud)
   {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
   }

}

public class MultipleConstructors
{
   public static void main(String args[])
   {
      new E();
      new E(4, 3, 2, 1);
   }
}