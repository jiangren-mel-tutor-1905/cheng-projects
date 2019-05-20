package fp.topic3.multiple.java8;

public class ImplementsInterfaceClass implements InterfaceA
{
   // a normal override i.e. implementation of an interface method from InterfaceA
   @Override
   public void foo()
   {
      System.out.println("InterfaceA.foo()");
   }
}
