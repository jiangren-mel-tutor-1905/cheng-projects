// demonstrate fundamental behaviour of Inner classes in Java
// written by Caspar Ryan for FP
package fp.topic6.inner.fundamentals;

public class Outer
{
   private String attribute = "Outer.attribute";

   private class Inner
   {
      // TODO: run once then comment this line and run again and see the difference!
      //private String attribute = "Inner.attribute";

      public Inner()
      {
         System.out.printf("Inner.attribute=%s\n", attribute);
         Outer.this.attribute = "Outer.attribute.modified.by.Inner";
         attribute = "Inner.attribute.modified.by.Inner";
         System.out.printf("Inner.attribute=%s\n", attribute);
      }
   }

   public Outer()
   {
      // this.attribute = null;
      System.out.printf("Outer.attribute=%s\n", attribute);
      new Inner();
      System.out.printf("Outer.attribute=%s\n", attribute);
   }

   public static void main(String args[])
   {
      new Outer();
   }
}
