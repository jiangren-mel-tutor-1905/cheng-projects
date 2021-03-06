package fp.topic2.constuctors;

/**
 * Example showing partial construction in a class hierarchy. Each class
 * constructs its own attributes and delegates the rest to super(...)
 * 
 * @author Caspar Ryan
 * 
 */
@SuppressWarnings("unused")
class A
{
   private int a;

   public A(int a)
   {
      //super();
      this.a = a;
   }
}

class B extends A
{
   private int b1;
   private int b2;

   public B(int a, int b1, int b2)
   {
      // class A constructs attribute 'a'
      super(a);
      this.b1 = b1;
      this.b2 = b2;
   }

   protected int getB1()
   {
      return b1;
   }

   protected void setB1(int b1)
   {
      this.b1 = b1;
   }

   protected int getB2()
   {
      return b2;
   }

   protected void setB2(int b2)
   {
      this.b2 = b2;
   }
}

@SuppressWarnings("unused")
abstract class C extends B
{
   private int c;

   // all constructors generated by eclipse :)
   public C(int a, int b1, int b2, int c)
   {
      // class B constructs everything except attribute 'c'
      super(a, b1, b2);
      this.c = c;
   }

   public void x(int a, int b1, int b2, int c)
   {

   }
}

class D extends C
{
   public D(int a, int b1, int b2, int c)
   {
      super(a, b1, b2, c);
   }

   @Override
   public void x(int a, int b1, int b2, int c)
   {
      super.x(a, b1, b2, c);
      // do something else

   }
}

public class InheritenceConstructors
{
   public static void main(String args[])
   {
      new D(1, 2, 3, 4);
   }
}