// demonstrate fundamental behaviour of Inner classes in Java
// written by Caspar Ryan for FP
package fp.topic6.inner.fundamentals;

public class OuterSeesInner
{
   private String attribute = "Outer.attribute";

   private class Inner
   {
      private String notSoSecret = "Secret?";

      public Inner()
      {
         System.out.printf("Inner.attribute=%s\n", attribute);
         OuterSeesInner.this.attribute = "Outer.attribute.modified.by.Inner";
         attribute = "Inner.attribute.modified.by.Inner";
         System.out.printf("Inner.attribute=%s\n", attribute);
      }
   }

   public OuterSeesInner()
   {
      // this.attribute = null;
      System.out.printf("Outer.attribute=%s\n", attribute);
      Inner inner = new Inner();
      System.out.printf("inner.notSoSecret=%s\n", inner.notSoSecret);
      inner.notSoSecret = "Nope!";
      System.out.printf("inner.notSoSecret=%s\n", inner.notSoSecret);
   }

   public static void main(String args[])
   {
      new OuterSeesInner();
   }
}
