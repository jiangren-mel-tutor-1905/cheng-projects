package fp.topic3.multiple.java8;

// an interface with a default method that can have a body (but no field/attribute access)
// NOTE: Java 8 and above only
public interface InterfaceB
{
   default void foo()
   {
      System.out.println("InterfaceB.foo()");
   }
}
