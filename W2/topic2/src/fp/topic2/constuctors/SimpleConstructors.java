package fp.topic2.constuctors;

public class SimpleConstructors
{
   @SuppressWarnings("unused")
   private int x;

   public SimpleConstructors()
   {
      // recursive call causes compile error 
      // (see if you can work out why and fix while leaving the constructor call uncommented!)
      //this(1);
   }

   public SimpleConstructors(int x)
   {
      this();
      this.x = x;
   }

   public static void main(String args[])
   {
      new SimpleConstructors();
      new SimpleConstructors(1);
   }
}